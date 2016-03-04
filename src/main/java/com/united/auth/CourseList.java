/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.auth;

import com.united.persistence.AbstractDAO;
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
    
    
}
