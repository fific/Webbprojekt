package com.united.core;


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
     @Inject
     private UserList userList;
     
     @Inject
     private CourseList courseList;
    
     @Inject
     private MomentList momentList;
     
     @Inject
     private FinishedMomentList finishedmomentList;
     
     @Inject
     private QuestionList questionList;
     
     @Inject
     private RegistrationList registrationList;
     
     @Inject
     private AnswerList answerList;
     
      @Inject
     private Parent_childList parent_childList;

     
    
    public School() {
        Logger.getAnonymousLogger().log(Level.INFO, "School alive");
    }
   
    public UserList getUserList() {
        return userList;
    }
    
     public Parent_childList getParent_childList() {
        return parent_childList;
    }
    
    public CourseList getCourseList() {
        return courseList;
    }
    
    public MomentList getMomentList() {
        return momentList;
    }
    
    public FinishedMomentList getFinishedMomentList() {
        return finishedmomentList;
    }
    
     public QuestionList getQuestionList() {
        return questionList;
    }
     
     public RegistrationList getRegistrationList() {
        return registrationList;
    }
     
     public AnswerList getAnswerList() {
        return answerList;
    }
     
    public SingletonSchool getSchool() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
