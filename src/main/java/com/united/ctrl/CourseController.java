package com.united.ctrl;

import com.united.auth.Groups;
import com.united.auth.User;
import com.united.core.Course;
import com.united.core.Registration;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.courses.AddCourseBB;
import com.united.view.courses.CurrentCourseBB;
import com.united.view.courses.DeleteCourseBB;
import com.united.view.courses.EditCourseBB;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 @author Linn
 */
@Named("courseController")
@RequestScoped
public class CourseController {

    private static final Logger LOG = Logger.getLogger(CourseController.class.getSimpleName());
    
    @Inject
    private School school;
    
    private AddCourseBB addBB;
    private EditCourseBB editBB;
    private DeleteCourseBB delBB;
    private CurrentCourseBB currentBB;
   
     public void newCourse() {
       //LOG.log(Level.INFO, "Backing bean " + addBB);
       Course c = new Course(addBB.getId(), addBB.getName());
       school.getCourseList().create(c);
       
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
        
       Registration r = new Registration(u, c);
       school.getRegistrationList().create(r);
    }

     public void updateCourse() {
       Course c = new Course(Objects.toString(editBB.getId()), editBB.getName());
       school.getCourseList().update(c);    
    }

    public void deleteCourse() {
       Course c = new Course(Objects.toString(delBB.getId()), delBB.getName());
       List<Registration> rl = school.getRegistrationList().getAllRegistrationsForCourse(c);
       for(Registration r : rl) {
           school.getRegistrationList().delete(r.getId());
       }
        
       String id = Objects.toString(delBB.getId());
       school.getCourseList().delete(id);
    }
    
    // Bug fix: change student status while set current course.
    public void setCurrentCourse() {
        Course c = new Course(currentBB.getId(), currentBB.getName());
        List<Registration> rl = school.getRegistrationList().getAllRegistrationsForUsername();
        for(Registration r : rl) {
           r.setCurrentCourse("false");
           school.getRegistrationList().update(r);
        }
        
        rl = school.getRegistrationList().getAllRegistrationsForCourse(c);
        for(Registration r : rl) {
           r.setCurrentCourse("true");
           school.getRegistrationList().update(r);
        }
        
        List<User> ul = school.getUserList().getStudentsByUser();
    }
 
    @Inject
    public void setAddBB(AddCourseBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setEditBB(EditCourseBB editBB) {
        this.editBB = editBB;
    }
    
    @Inject
    public void setDelBB(DeleteCourseBB delBB) {
        this.delBB = delBB;
    }
    
    @Inject
    public void setCurrentBB(CurrentCourseBB currentBB) {
        this.currentBB = currentBB;
    }

//    @Inject
//    public void setSchool(SingletonSchool ss) {
//        this.school = ss.getSchool();
//    }
    
    public int countCourses() {
        return school.getCourseList().count();
    }

}
