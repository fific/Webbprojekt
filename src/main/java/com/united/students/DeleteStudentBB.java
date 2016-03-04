package com.united.students;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("deleteStudent")
@RequestScoped 
public class DeleteStudentBB {

    private String id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "DeleteStudentBB{" + "name=" + name + ", passwd=" + password + '}';
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
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 
}
