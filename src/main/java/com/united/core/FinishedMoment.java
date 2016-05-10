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


/**
 * Many to many
 * Many users can have finished many moments, and many moments can have
 * many users who finished them.
 * This class connects users and moments.
 * 
 * @author Linn
 */
@Entity
@Table(name = "FINISHEDMOMENTS")
public class FinishedMoment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    protected String time;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    private User user;

    //@ManyToOne(cascade = javax.persistence.CascadeType.ALL)
    @ManyToOne
    private Moment moment;

    public FinishedMoment(User user, Moment moment, String time) {
        this.user = user;
        this.moment = moment;
        this.time = time;
    }

    public FinishedMoment() {
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
    
    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        final FinishedMoment other = (FinishedMoment) obj;
        return Objects.equals(this.id, other.id);
    }
}
