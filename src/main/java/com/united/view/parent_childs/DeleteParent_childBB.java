package com.united.view.parent_childs;

import com.united.auth.Groups;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.united.auth.User;

/**
 *
         Backing bean

 */
@Named("deleteParent_child")
@RequestScoped 
public class DeleteParent_childBB {

    private String id;
    private String name;
    private String password;
    private Groups groups;
    
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
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}

