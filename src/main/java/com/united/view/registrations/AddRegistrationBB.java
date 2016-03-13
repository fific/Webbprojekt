
package com.united.view.registrations;

import com.united.core.Course;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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
