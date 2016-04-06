/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.view.answers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

@Named("addAnswer")
@RequestScoped 
public class AddAnswerBB {

    @Size(min = 1, max = 20, message = "{answer.id}")
    private String id;
    
    @Size(min = 1, max = 100, message = "{answer.answer}")
    private String answer;
    
    @Size(min = 1, max = 100, message = "{answer.correctness}")
    private String correctness;
    
    private String questionId;
    
    
     public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String getCorrectness() {
        return correctness;
    }

    public void setCorrectness(String correctness) {
        this.correctness = correctness;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "AddQuestionBB{" + "answer=" + answer + '}';
    }  
    
}
