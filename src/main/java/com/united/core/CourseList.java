package com.united.core;

import com.united.auth.*;
import com.united.persistence.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jenny
 */

@Stateless
public class CourseList extends AbstractDAO<Course, String> {
    private static final Logger LOG = Logger.getLogger(CourseList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public CourseList() {
        super(Course.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "CourseList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     
    public List<Course> getByName(String id) {
        String jpql = "select c from Course c where c.id=:id";
        return em.createQuery(jpql, Course.class).
                setParameter("id", id).getResultList();
    }
    /*
    public List<User> getAllStudents() {
        String jpql = "SELECT p FROM User p WHERE p.groups=:group";
        List<Groups> groupList  = new ArrayList<>();
        groupList.add(Groups.STUDENT);
        return em.createQuery(jpql, User.class).setParameter("group", groupList).getResultList();
    }*/
    
    
    
    
}
