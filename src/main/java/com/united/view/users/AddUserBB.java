
package com.united.view.users;

import com.united.auth.Groups;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
         Backing bean

 */
@Named("addUser")
@RequestScoped 
public class AddUserBB {

    
    @Size(min = 4, max = 20, message = "{user.name}")
    private String id;
    
    private String passwd;
    private String name;
    private Groups groups;
    
    
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

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
 
    

    
}
