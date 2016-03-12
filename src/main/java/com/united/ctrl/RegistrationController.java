package com.united.ctrl;




import com.united.core.Registration;
import com.united.core.School;
import com.united.view.registrations.AddRegistrationBB;
import com.united.view.registrations.DeleteRegistrationBB;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 */
@Named("registrationController")
@RequestScoped
public class RegistrationController {

    private static final Logger LOG = Logger.getLogger(RegistrationController.class.getSimpleName());
    
    @Inject
    private School school;
    
    private AddRegistrationBB addBB;
    private DeleteRegistrationBB delBB;
    
   
     public void newRegistration() {
       LOG.log(Level.INFO, "Backing bean " + addBB);
       Registration p = new Registration(addBB.getUser(), addBB.getCourse());
        school.getRegistrationList().create(p);
    }

    public void deleteRegistration() {
       Long id = delBB.getId();
       school.getRegistrationList().delete(id);
    }

    @Inject
    public void setAddBB(AddRegistrationBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setDelBB(DeleteRegistrationBB delBB) {
        this.delBB = delBB;
    }

//    @Inject
//    public void setSchool(SingletonSchool ss) {
//        this.school = ss.getSchool();
//    }

}
