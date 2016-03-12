package com.united.core;

import com.united.auth.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jenny & linn
 */

@Entity
@Table(name="MOMENTS")
public class Moment implements Serializable {

    
    
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    protected String name;
    
    //The "many" side of the relation
    //The "one" side can be found in Course
    @ManyToOne
    @JoinColumn(name = "IN_COURSE")
    private Course course;
    
    
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();
    
    

    public Moment() {
    }

    public Moment(String name) {
        this.name = name ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void addToQuestions(Question question){
//        question.setMoment(this);
//        this.questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Moment other = (Moment) obj;
        return Objects.equals(this.id, other.id);
    }

}