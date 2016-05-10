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
public class MomentList extends AbstractDAO<Moment, Long> {
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
    
    public Moment getById(Long id) {
        String jpql = "select m from Moment m where m.id=:id";
        return em.createQuery(jpql, Moment.class).
                setParameter("id", id).getSingleResult();
    }
    
    public List<Moment> getByCourse(Course c) {
        String jpql = "select m from Moment m where m.course=:course";
        return em.createQuery(jpql, Moment.class).
                setParameter("course", c).getResultList();
    }
}
