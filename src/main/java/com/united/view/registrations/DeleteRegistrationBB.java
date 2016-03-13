
package com.united.view.registrations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
         Backing bean

 */
@Named("deleteRegistration")
@RequestScoped 
public class DeleteRegistrationBB {

    private String courseid;
    private String coursename;
    
    private Long id; //registration id
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    
    
}
