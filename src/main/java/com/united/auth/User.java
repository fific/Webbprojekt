package com.united.auth;

import com.united.core.Answer;
import com.united.core.Message;
import com.united.core.Moment;
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User table in database
 *
 * NOTE : User is a reserved word in SQL
 * 
 * @author hajo
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)  // unique is implied
    protected String id;
    @Column(nullable = false)
    protected String passwd;
    @Column(nullable = false)
    protected String name;
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "USERS_GROUPS", 
            joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    protected List<Groups> groups = new ArrayList<>();
    
    
    //The "one" side of the relation
    //The "many" side can be found in Message
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<Message> sentMessages = new ArrayList<>();
    
    //The "one" side of the relation
    //The "many" side can be found in Message
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<Message> receivedMessages = new ArrayList<>();
    
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();

    public User() {
    }

    public User(String id, String passwd, String name, Groups group) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        System.out.println("***trying to add group in User constructor. groups: " + groups);
        groups.add(group);
    }

    public void addGroup(Groups group) {
        groups.add(group);
    }

    public void removeGroup(Groups group) {
        groups.remove(group);
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addToAnswers(Answer answer){
        answers.add(answer);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }
    
    public List<Answer> getAnswers() {
        return answers;
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

}
