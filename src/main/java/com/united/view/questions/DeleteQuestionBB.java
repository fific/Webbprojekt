
package com.united.view.questions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;


@Named("deleteQuestion")
@RequestScoped 
public class DeleteQuestionBB {

    @Size(min = 1, max = 20, message = "{question.id}")
    private int id;
    
    @Size(min = 1, max = 100, message = "{question.name}")
    private String question;
    
    @Size(min = 1, max = 100, message = "{question.name}")
    private String answer;

    public String getQuestion() {
        return question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "DeleteQuestionBB{" + "question=" + question + '}';
    }  
}
