package com.united.moments;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("deleteMoment")
@RequestScoped 
public class DeleteMomentBB {

    private String id;
    private String name;

    @Override
    public String toString() {
        return "DeleteStudentBB{" + "id=" + id + ", name=" + name + '}';
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
}

