
package com.united.view.questions;

import com.united.view.courses.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Named("editQuestion")
@RequestScoped 
public class EditQuestionBB {

    
    @Size(min = 1, max = 20, message = "{question.id}")
    private String id;
    
    @Size(min = 1, max = 100, message = "{question.name}")
    private String question;
    
    @Size(min = 1, max = 100, message = "{question.name}")
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "EditQuestionBB{" + "question=" + question + '}';
    }  
}
