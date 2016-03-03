package com.united.ctrl;



import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.courses.AddCourseBB;
import com.united.view.courses.DeleteCourseBB;
import com.united.view.courses.EditCourseBB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
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
    private School school;
    
    private AddCourseBB addBB;
    private EditCourseBB editBB;
    private DeleteCourseBB delBB;
    
   
    public void newCourse() {
//        LOG.log(Level.INFO, "Backing bean " + addBB);
//        Course p = new Course(addBB.getName(), Double.valueOf(addBB.getPrice()));
//        school.getCourseList().create(p);
//        List<Course> ps = school.getCourseList().getByName(addBB.getName());      
//        LOG.log(Level.INFO, "New value " + ps.get(0));
    }

    public void updateCourse() {
//       Course p = new Course(editBB.getId(), editBB.getName(), Double.valueOf(editBB.getPrice()));
//       school.getCourseList().update(p);    
    }

    public void deleteCourse() {
//       String id = delBB.getId();
//       school.getCourseList().delete(id);
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
    public void setSchool(SingletonSchool ss) {
        this.school = ss.getSchool();
    }

}
