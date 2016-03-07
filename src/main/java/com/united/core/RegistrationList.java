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
public class RegistrationList extends AbstractDAO<Registration, Long> {
    private static final Logger LOG = Logger.getLogger(RegistrationList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public RegistrationList() {
        super(Registration.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "RegistrationList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     
    public List<Registration> getById(Long id) {
        String jpql = "select r from Registration r where r.id=:id";
        return em.createQuery(jpql, Registration.class).
                setParameter("id", id).getResultList();
    }
    
    
}
