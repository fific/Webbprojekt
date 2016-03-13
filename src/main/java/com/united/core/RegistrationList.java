package com.united.core;

import com.united.auth.User;
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

/**
 *
 * @author Linn, Quang
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
        String jpql = "SELECT r FROM Registration r WHERE r.id=:id";
        return em.createQuery(jpql, Registration.class).
                setParameter("id", id).getResultList();
    }
    
    public List<Registration> getAllRegistrationsForUsername() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
        
        String jpql = "SELECT r FROM Registration r WHERE r.user=:user";
        return em.createQuery(jpql, Registration.class).
                setParameter("user", u).getResultList();
    }
   
}
