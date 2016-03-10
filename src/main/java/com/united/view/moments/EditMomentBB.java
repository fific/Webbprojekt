package com.united.view.moments;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Named("editMoment")
@RequestScoped 
public class EditMomentBB {

    private String id;
    
    @Size(min = 4, max = 20, message = "Använd mellan 4 och 20 tecken.")
    private String name;

    @Override
    public String toString() {
        return "EditMomentBB{" + "id=" + id + ", name=" + name + '}';
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
