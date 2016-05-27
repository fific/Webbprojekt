package com.united.core;

import com.united.auth.Groups;
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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author
 * Många medtoder här är oprövade
 */

@Stateless
public class Parent_childList extends AbstractDAO<Parent_child, Long> {
    private static final Logger LOG = Logger.getLogger(Parent_childList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public Parent_childList() {
        super(Parent_child.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "Parent_childList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
         
    public List<Parent_child> getById(Long id) {
        String jpql = "SELECT p FROM Parent_child p WHERE p.id=:id";
        /*return em.createQuery(jpql, Parent_child.class).
                setParameter("id", id).getResultList();*/
        LOG.log(Level.INFO, "Parent_childList getById kördes");
        return null;
    }
    // osäker på om denna fungerar
    public List<Parent_child> getAllParent_childForUser() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("parent");
        
        String jpql = "SELECT p FROM Parent_child p WHERE p.parent=:user";
        //return em.createQuery(jpql, Parent_child.class).
          //      setParameter("user", u).getResultList();
                  LOG.log(Level.INFO, "Parent_childList getAllParent_childForUser kördes");
                  return null;
    }
    
    public List<Parent_child> getAllParentsForChild() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User child = (User) sessionMap.get("user");
       LOG.log(Level.INFO, "Parent_childList getAllParentsForChild kördes utan inparameterar");

        String jpql = "SELECT c FROM Parent_child c WHERE c.child=:child";
        return em.createQuery(jpql, Parent_child.class).
                setParameter("child", child).getResultList();
        //return null;
    }
    
      public List<Parent_child> getAllChildrenForParent() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User parent = (User) sessionMap.get("user");
       LOG.log(Level.INFO, "Parent_childList getAllChildrenForParent kördes utan inparameterar");

        String jpql = "SELECT c FROM Parent_child c WHERE c.parent=:parent";
        return em.createQuery(jpql, Parent_child.class).
                setParameter("parent", parent).getResultList();
        //return null;
    }
      
      
    public List<Parent_child> getAllParent_ChildForParent(User u) {
        String jpql = "SELECT x FROM Parent_child x WHERE x.child=:user";
        //return em.createQuery(jpql, Parent_child.class).
                //setParameter("user", u).getResultList();
        LOG.log(Level.INFO, "Parent_childList getAllParent_ChildForParent kördes");
        return null;

    }
    
    public List<Parent_child> getAllParentsForChild(User child) {
        String jpql = "SELECT x FROM Parent_child x WHERE x.child=:child";
                LOG.log(Level.INFO, "Parent_childList getAllParent_ChildForChild kördes");
        return em.createQuery(jpql, Parent_child.class).
                setParameter("child", child).getResultList();
            //return null;
    }
      
}
