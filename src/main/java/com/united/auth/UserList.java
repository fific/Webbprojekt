
package com.united.auth;

import com.united.core.Course;
import com.united.core.Registration;
import com.united.persistence.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Linn
 */
@Stateless
public class UserList extends AbstractDAO<User, String> {
    private static final Logger LOG = Logger.getLogger(UserList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public UserList() {
        super(User.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "UserList alive");
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Registration> getSTRegistration() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
       String jpql = "SELECT a FROM Registration a WHERE a.course IN (SELECT r.course FROM Registration r WHERE r.user=:user)";
       return em.createQuery(jpql, Registration.class).setParameter("user", u).getResultList();
    }
    
    public List<Registration> getStudentsRegistration(String id) {
        List<Registration> rl = getSTRegistration();
        List<Registration> srl = new ArrayList<Registration>();
        for(Registration r : rl) {
           if(r.getUser().getId().equals(id)) {
               srl.add(r);
           }
        }
        return srl;
    }
    
    public List<User> getStudentsByUser() {
       User user;
       List<User> sl = new ArrayList<User>();
       
       List<Registration> rl = getSTRegistration();
       for(Registration r : rl) {
           user = r.getUser();
           if(user.getGroups().get(0) == Groups.STUDENT) {
               sl.add(user);
           }
       }
       return sl;
    }
    
    public List<User> getAllStudents() {
        String jpql = "SELECT p FROM User p WHERE p.groups=:group";
        List<Groups> groupList  = new ArrayList<>();
        groupList.add(Groups.STUDENT);
        return em.createQuery(jpql, User.class).setParameter("group", groupList).getResultList();
    }
    
    public List<User> getAllTeachers() {
        String jpql = "SELECT p FROM User p WHERE p.groups=:group";
        List<Groups> groupList  = new ArrayList<>();
        groupList.add(Groups.TEACHER);
        return em.createQuery(jpql, User.class).setParameter("group", groupList).getResultList();
    }
    
}
