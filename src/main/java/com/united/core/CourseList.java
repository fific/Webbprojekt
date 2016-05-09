package com.united.core;

import com.united.auth.*;
import com.united.persistence.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

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
    
     
    public Course getById(String id) {
        String jpql = "select c from Course c where c.id=:id";
        return em.createQuery(jpql, Course.class).
                setParameter("id", id).getSingleResult();
    }
    
    public String generatedCourseId(String id) {
		Random rand = new Random();
		String newId = id + "_clone";
		List<Registration> list = new ArrayList<Registration>();
		boolean exist = true;
		
		while(exist) {
                    newId = newId + rand.nextInt(1000);
                    
                    String jpql = "SELECT c.id FROM Course c WHERE c.id=:id";
                    list = em.createQuery(jpql, Registration.class).setParameter("id", newId).getResultList();
                    
                    if(list.isEmpty())
			exist = false;
		}
		return newId;
    }
    
    
    
    
}
