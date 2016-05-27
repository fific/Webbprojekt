package com.united.core;

import com.united.auth.User;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "PARENT_CHILD", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"USER_ID", "USER_ID_ID"})
})
public class Parent_child implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    public User parent;

    @ManyToOne
    public User child;
    
    public Parent_child(User parent, User child) {
        this.parent = parent;
        this.child = child;
    }
    
    

    public Parent_child() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }
    
    public User getChild() {
        return child;
    }

    public void setChild(User child) {
        this.child = child;
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
        final Parent_child other = (Parent_child) obj;
        return Objects.equals(this.id, other.id);
    }
}

