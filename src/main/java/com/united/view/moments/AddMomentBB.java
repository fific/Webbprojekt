package com.united.view.moments;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("addMoment")
@RequestScoped 
public class AddMomentBB {
    
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{student.id}")
    private String id;
    
    @Size(min = 4, max = 20, message = "Använd mellan 4 och 20 tecken.")
    private String name;

    private String courseId;
    
    @Override
    public String toString() {
        return "AddMomentBB{" + "id=" + id + "name=" + name + '}';
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
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public String redirectWithParam(){
        System.out.println("---courseID: " + courseId);
//        return "momentList?faces-redirect=true&includeViewParams=true"; 
        return "momentList?faces-redirect=true&includeViewParams=true"; 
    }
    
}