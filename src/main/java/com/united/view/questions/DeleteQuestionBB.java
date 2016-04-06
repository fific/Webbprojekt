
package com.united.view.questions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;


@Named("deleteQuestion")
@RequestScoped 
public class DeleteQuestionBB {

    @Size(min = 1, max = 200, message = "{question.id}")
    private String id;
    
    @Size(min = 1, max = 100, message = "{question.name}")
    private String question;
    
    @Size(min = 1, max = 100, message = "{question.answer}")
    private String answer;
    
    private Long momentId;

    public String getQuestion() {
        return question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public String getId() {
        return id;
    }
    
   public void setId(String id) {
        this.id = id;
    }
   
   public Long getMomentId() {
        return momentId;
    }
    
   public void setMomentId(Long momentId) {
        this.momentId = momentId;
    }
    
    @Override
    public String toString() {
        return "DeleteQuestionBB{" + "question=" + question + '}';
    }  
}
