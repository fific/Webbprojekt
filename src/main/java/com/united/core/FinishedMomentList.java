package com.united.core;

import com.united.auth.User;
import com.united.persistence.AbstractDAO;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    
     
    public FinishedMoment getByMoment(Moment m) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
        
        return getByMomentUser(m, u);
    }
    
    public FinishedMoment getByMomentUser(Moment m, User u) {
        String jpql = "select fm from FinishedMoment fm where fm.moment=:moment and fm.user=:user";
        try {
            return em.createQuery(jpql, FinishedMoment.class).
                setParameter("moment", m).
                setParameter("user", u).getSingleResult();
        }
        catch(NoResultException e) {
            return null;
        }
    }
}
