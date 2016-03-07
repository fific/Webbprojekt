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
public class QuestionList extends AbstractDAO<Question, String> {
    private static final Logger LOG = Logger.getLogger(QuestionList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public QuestionList() {
        super(Question.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "QuestionList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Question> getByName(String id) {
        String jpql = "select q from Question q where q.id=:id";
        return em.createQuery(jpql, Question.class).
                setParameter("id", id).getResultList();
    }
}
