package com.united.ctrl;



import com.united.core.Moment;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.moments.AddMomentBB;
import com.united.view.moments.DeleteMomentBB;
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
@Named("momentController")
@RequestScoped
public class MomentController {

    private static final Logger LOG = Logger.getLogger(MomentController.class.getSimpleName());

    @Inject
    private School school;
    
    private AddMomentBB addBB;
//    private EditMomentBB editBB;
    private DeleteMomentBB delBB;
    
   
    public void newMoment(String courseId) {
        System.out.println("*******courseId is: " + courseId);
        Moment p = new Moment(addBB.getName());
        school.getMomentList().create(p);
        school.getCourseList().getById(courseId).addMoment(p);
    }

    public void updateMoment() {
//       Moment p = new Moment(editBB.getId(), editBB.getName());
//       school.getMomentList().update(p);    
    }

    public void deleteMoment() {
        Long id = Long.parseLong(delBB.getId());
        school.getMomentList().delete(id);
    }

    @Inject
    public void setAddBB(AddMomentBB addBB) {
        this.addBB = addBB;
    }
    
//    @Inject
//    public void setEditBB(EditMomentBB editBB) {
//        this.editBB = editBB;
//    }
    
    @Inject
    public void setDelBB(DeleteMomentBB delBB) {
        this.delBB = delBB;
    }


}
