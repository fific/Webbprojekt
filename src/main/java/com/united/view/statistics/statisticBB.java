package com.united.view.statistics;

import com.united.core.Answer;
import com.united.core.Course;
import com.united.core.Moment;
import com.united.core.Question;
import com.united.core.Registration;
import com.united.core.School;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("statistic")
@ViewScoped
public class statisticBB implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    
    @Inject
    private School school;
    
    public String getQuestionStatistic(Question q) {
        String jpql = "select a from Answer a where a.question=:question";
        List<Answer> list = em.createQuery(jpql, Answer.class).setParameter("question", q).getResultList();
        List<Answer> rList = new ArrayList<>();
        for(Answer a : list) {
            if(a.getCorrectness().equals("true"))
                rList.add(a);
        }
        return (rList.size()-1)/list.size()*100 + "%";
    }
}
