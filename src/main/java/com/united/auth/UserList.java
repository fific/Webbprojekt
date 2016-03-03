
package com.united.auth;

import com.united.persistence.AbstractDAO;
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
public class UserList extends AbstractDAO<User, String> {
    private static final Logger LOG = Logger.getLogger(UserList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public UserList() {
        super(User.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "UserList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
