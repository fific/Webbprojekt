package com.united.view.moments;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("deleteMoment")
@RequestScoped 
public class DeleteMomentBB {

    private String id;
    private String name;
    private String courseid;
    private String coursename;

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
    
    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }
    
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    
    public String ForwardPage(){
        return "momentList?course_id=" + courseid + "&course_name=" + coursename + "faces-redirect=true";
    }
}

