
package com.united.auth;

import com.united.persistence.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
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
    protected EntityManager getEntityManager() {
        return em;
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
