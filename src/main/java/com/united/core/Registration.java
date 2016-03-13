package com.united.core;

import com.united.auth.User;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Many to many
 * Many users can be registered on many courses, and many courses can have
 * many registered users.
 * This class connects users and courses.
 * Every row in the table must be unique = the same registration cant
 * be made twice.
 * @author Linn
 */
@Entity
@Table(name = "REGISTRATIONS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"USER_ID", "COURSE_ID"})
})
public class Registration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    public Registration(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public Registration() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
        final Registration other = (Registration) obj;
        return Objects.equals(this.id, other.id);
    }
}
