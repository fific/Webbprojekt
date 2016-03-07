package com.united.core;

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
 * @author Linn
 */

@Stateless
public class FinishedMomentList extends AbstractDAO<FinishedMoment, Long> {
    private static final Logger LOG = Logger.getLogger(FinishedMomentList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public FinishedMomentList() {
        super(FinishedMoment.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "FinishedMomentList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     
    public List<FinishedMoment> getById(Long id) {
        String jpql = "select r from FinishedMoment r where r.id=:id";
        return em.createQuery(jpql, FinishedMoment.class).
                setParameter("id", id).getResultList();
    }
    
    
}
