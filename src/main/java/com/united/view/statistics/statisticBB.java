package com.united.view.statistics;

import com.united.auth.User;
import com.united.core.Answer;
import com.united.core.Course;
import com.united.core.Moment;
import com.united.core.Question;
import com.united.core.Registration;
import com.united.core.School;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Named("statistic")
@ViewScoped
public class statisticBB implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    
    @Inject
    private School school;
    
    public String getCourseStatistic(Course c) {
        
        return "";
    }
    
    public String getQuestionStatisticTeacher(Question q) {
        String jpql = "select a from Answer a where a.question=:question";
        List<Answer> list = em.createQuery(jpql, Answer.class).setParameter("question", q).getResultList();
        List<Answer> rList = new ArrayList<>();
        if(list.isEmpty())
            return "-";
        for(Answer a : list) {
            if(a.getCorrectness().equals("true"))
                rList.add(a);
        }
        return (rList.size()-1)/list.size()*100 + " %";
    }
    
    public String getQuestionStatistic(Question q) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
        
        return getQuestionStatistic(q, u.getId());
    }
    
    public String getQuestionStatistic(Question q, String userid) {
        String jpql = "select a from Answer a where a.question=:question and a.user=:user";
        List<Answer> list = em.createQuery(jpql, Answer.class).setParameter("question", q).setParameter("user", school.getUserList().getById(userid)).getResultList();
        List<Answer> rList = new ArrayList<>();
        if(list.isEmpty())
            return "-";
        for(Answer a : list) {
            if(a.getCorrectness().equals("true"))
                rList.add(a);
        } 
        return Math.round(((float)rList.size()-1)/(float)list.size()*100) + " %";
    }
    
    // Return yes if the moment is completed. Otherwise no.
    public String finishedmoment(Moment m) {
        if(school.getFinishedMomentList().getByMoment(m) == null)
            return "Ej avklarad";
        else 
            return "Avklarad";
    }
    
    public String finishedmoment(Moment m, String userid) {
        if(school.getFinishedMomentList().getByMomentUser(m, school.getUserList().getById(userid)) == null)
            return "Ej avklarad";
        else 
            return "Avklarad";
    }
    
    public String usedTime(Moment m) {
        if(school.getFinishedMomentList().getByMoment(m) == null)
            return "-";
        else 
            return school.getFinishedMomentList().getByMoment(m).getTime();
    }
    
    public String usedTime(Moment m, String userid) {
        if(school.getFinishedMomentList().getByMomentUser(m, school.getUserList().getById(userid)) == null)
            return "-";
        else 
            return school.getFinishedMomentList().getByMomentUser(m, school.getUserList().getById(userid)).getTime();
    }
    
    public String finishedmoments(Course c) {
        int finishedmoments = 0;
        for(Moment m : c.getMoments()) {
            if(school.getFinishedMomentList().getByMoment(m) != null)
                finishedmoments++;
        }
        return finishedmoments + " / " + c.getMoments().size();
    }
    
    public String finishedmoments(Course c, String userid) {
        int finishedmoments = 0;
        for(Moment m : c.getMoments()) {
            if(school.getFinishedMomentList().getByMomentUser(m, school.getUserList().getById(userid)) != null)
                finishedmoments++;
        }
        return finishedmoments + " / " + c.getMoments().size();
    }
}
