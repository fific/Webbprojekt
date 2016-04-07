/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.view.answers;

import com.united.core.Moment;
import com.united.core.MomentList;
import com.united.core.Question;
import com.united.core.QuestionList;
import com.united.core.School;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Fifi
 */
@Named("answerList")
@ViewScoped
public class AnswerListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(AnswerListBB.class.getName());

//    private transient School school;
    @Inject     //Is this an OK solution?
    private School school;
    
    private int currentPage;
    private int pageSize = 10;  // Items on a listing (hard coded :-(  )
    private int count;
    private String momentId;
    private String id;
    private String name;
    
    @Inject
    private MomentList moments;
    
    @Inject
    private QuestionList questions;

public String getMomentId() {
        return momentId;
    }

    public void setMomentId(String momentId) {
        this.momentId = momentId;
    }

    public List<Question> findRange() {
        Moment selectedMoment = moments.getById(Long.parseLong(momentId));
        return selectedMoment.getQuestions();
        
//        return school.getQuestionList().findRange(currentPage * pageSize, pageSize);
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PostConstruct
    public void post() {
        count = school.getQuestionList().count();
    }

    public void next() {
        if (currentPage < (count / pageSize)) {
            currentPage = currentPage + 1;
        }
    }

    public void prev() {
        if (currentPage > 0) {
            currentPage = currentPage - 1;
        }
    }

}
