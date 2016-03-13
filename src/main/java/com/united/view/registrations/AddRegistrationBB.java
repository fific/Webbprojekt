
package com.united.view.registrations;

import com.united.auth.User;
import com.united.core.Course;
import com.united.view.courses.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
         Backing bean

 */
@Named("addRegistration")
@RequestScoped 
public class AddRegistrationBB {
    
    // User from session scope is used
    
    
    private String id; // course id to add
    private Course course; //currently unused

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
