package com.united.ctrl;



import com.united.core.School;
import com.united.core.SingletonSchool;
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
    private School school;
    
//    private AddMomentBB addBB;
//    private EditMomentBB editBB;
//    private DeleteMomentBB delBB;
    
   
    public void newMoment() {
//        LOG.log(Level.INFO, "Backing bean " + addBB);
//        Moment p = new Moment(addBB.getName(), Double.valueOf(addBB.getPrice()));
//        school.getMomentList().create(p);
//        List<Moment> ps = school.getMomentList().getByName(addBB.getName());      
//        LOG.log(Level.INFO, "New value " + ps.get(0));
    }

    public void updateMoment() {
//       Moment p = new Moment(editBB.getId(), editBB.getName(), Double.valueOf(editBB.getPrice()));
//       school.getMomentList().update(p);    
    }

    public void deleteMoment() {
//       String id = delBB.getId();
//       school.getMomentList().delete(id);
    }

//    @Inject
//    public void setAddBB(AddMomentBB addBB) {
//        this.addBB = addBB;
//    }
//    
//    @Inject
//    public void setEditBB(EditMomentBB editBB) {
//        this.editBB = editBB;
//    }
//    
//    @Inject
//    public void setDelBB(DeleteMomentBB delBB) {
//        this.delBB = delBB;
//    }

    @Inject
    public void setSchool(SingletonSchool ss) {
        this.school = ss.getSchool();
    }

}
