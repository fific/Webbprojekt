
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
    
    
    private Long id;
    private Course course; //currently unused

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
