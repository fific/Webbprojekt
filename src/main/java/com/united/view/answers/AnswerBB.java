/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.view.answers;

import com.united.core.Answer;
import com.united.core.AnswerList;
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
@Named("answer")
@ViewScoped
public class AnswerBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(AnswerBB.class.getName());

    @Inject
    private School school;
    
    private String momentId;
    private String id;
    private String name;
    
    @Inject
    private AnswerList answers;
    
    @Inject
    private QuestionList questions;

    public String findCorrectAnswer(Question question) {
        return answers.getById(question).getAnswer();
    }
}
