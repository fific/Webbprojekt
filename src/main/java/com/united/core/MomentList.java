/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.core;

import com.united.auth.*;
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
public class MomentList extends AbstractDAO<Moment, String> {
    private static final Logger LOG = Logger.getLogger(MomentList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public MomentList() {
        super(Moment.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "MomentList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Moment> getByName(String id) {
        String jpql = "select m from Moment m where m.id=:id";
        return em.createQuery(jpql, Moment.class).
                setParameter("id", id).getResultList();
    }
}
