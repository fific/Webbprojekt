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
public class MessageList extends AbstractDAO<Message, String> {
    private static final Logger LOG = Logger.getLogger(MessageList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public MessageList() {
        super(Message.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "MessageList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Message> getByName(String id) {
        String jpql = "select m from Message m where m.id=:id";
        return em.createQuery(jpql, Message.class).
                setParameter("id", id).getResultList();
    }
}
