package com.united.core;

import com.united.auth.CourseList;
import com.united.auth.MomentList;
import com.united.auth.UserList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * School holds the User List, Course List and Moment List
 * 
 * @author Linn
 */
//@Named
@ApplicationScoped
public class School {
    //@Inject will not work!!! Because of interfaces+EBJs or similar
    // If interfaces removed it will work
     @EJB
     private UserList userList;
     
     @EJB
     private CourseList courseList;
    
     @EJB
     private MomentList momentList;

     
    
    public School() {
        Logger.getAnonymousLogger().log(Level.INFO, "School alive");
    }
   
    public UserList getUserList() {
        return userList;
    }
    
    public CourseList getCourseList() {
        return courseList;
        }
    
    public MomentList getMomentList() {
        return momentList;
        }

    public SingletonSchool getSchool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
