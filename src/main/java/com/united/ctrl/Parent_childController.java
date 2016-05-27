package com.united.ctrl;




import com.united.auth.User;
import com.united.core.Course;
import com.united.core.Moment;
import com.united.core.Parent_child;
import com.united.core.Registration;
import com.united.core.School;
import com.united.view.parent_childs.AddParent_childBB;
import com.united.view.parent_childs.DeleteParent_childBB;
import com.united.view.parent_childs.Parent_childListBB;
import com.united.view.parent_childs.AddParent_childBB;
//import com.united.view.registrations.DeleteRegistrationBB;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 */
@Named("parent_childController")
@RequestScoped
public class Parent_childController {

    private static final Logger LOG = Logger.getLogger(Parent_childController.class.getSimpleName());
    
    @Inject
    private School school;
    
    private AddParent_childBB addBB;
    private DeleteParent_childBB delBB;
    
   
   /*  public void newParent_child() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
       
       List<Parent_child> rl = school.getParent_childList().getAllParent_childForUser();
       if(school.getParent_childList().getAllParent_childForUser(school.getParent_childList().getById(addBB.getId())).equals("true")) {
            for(Registration r : rl) {
                r.setCurrentCourse("false");
                school.getRegistrationList().update(r);
            }
            school.getRegistrationList().create(new Registration(u, school.getCourseList().getById(addBB.getId()), "true"));
       }
       else
           school.getRegistrationList().create(new Registration(u, school.getCourseList().getById(addBB.getId())));
    }*/
    
    public void newParent_child(){
        
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
       LOG.log(Level.INFO, "Koden i Parent_childController körs");
    
       User selectedParent = school.getUserList().getById(addBB.getId());
       registerParent(selectedParent, u );
       
    }
    
    public void registerParent(User child, User parent){
        
        school.getParent_childList().create(new Parent_child(child, parent));
    }

    public void deleteParent() {
       String parentid = delBB.getId();
       Long id = school.getParent_childList().deleteParent_child(school.getUserList().getById(parentid)).getId();
       school.getParent_childList().delete(id);
    }
    
    public void deleteChild() {
       String childid = delBB.getId();
       Long id = school.getParent_childList().deleteChild(school.getUserList().getById(childid)).getId();
       school.getParent_childList().delete(id);
    }

    @Inject
    public void setAddBB(AddParent_childBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setDelBB(DeleteParent_childBB delBB) {
        this.delBB = delBB;
    }

}
