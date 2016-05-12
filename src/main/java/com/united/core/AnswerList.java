/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Fifi
 */
@Stateless
public class AnswerList extends AbstractDAO<Answer, Integer> {
    private static final Logger LOG = Logger.getLogger(AnswerList.class.getName());

    @PersistenceContext//(unitName = "school_pu")
    protected EntityManager em;

    public AnswerList() {
        super(Answer.class);
    }

     @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "AnswerList alive");
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     
    public List<Answer> getById(Question question) {
        String jpql = "select a from Answer a where a.question=:question AND a.correctness=true";
        return em.createQuery(jpql, Answer.class).
                setParameter("question", question).getResultList();
    }
}
