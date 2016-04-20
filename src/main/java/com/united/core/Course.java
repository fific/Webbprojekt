
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jenny & linn
 */

@Entity
@Table(name="COURSES")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    protected String id;
    @Column(nullable = false)
    protected String name;
    

//    //The "one" side of the relation
//    //The "many" side can be found in Moment
//    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//            fetch = FetchType.LAZY)
//    private List<Moment> containedMoments = new ArrayList<>();
    
    //The "one" side of the relation
    //The "many" side can be found in Moment
    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Moment> containedMoments = new ArrayList<>();
    

    public Course() {}

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void removeMoment(Moment moment) {

        moment.setCourse(null);
        this.containedMoments.remove(moment);
        
    }
    
    public List<Moment> getMoments() {
        return containedMoments;
    }
    
    public void setMoments(List<Moment> containedMoments) {
        this.containedMoments = containedMoments;
    }
    
    public void addToMoments(Moment moment){
        moment.setCourse(this);
        this.containedMoments.add(moment);
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
        final Course other = (Course) obj;
        return Objects.equals(this.id, other.id);
    }

}