
package com.united.questions;

import com.united.view.courses.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Named("addQuestion")
@RequestScoped 
public class AddQuestionBB {

    @Size(min = 4, max = 20, message = "{question.id}")
    private int id;
    
    @Size(min = 4, max = 20, message = "{question.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "AddQuestionBB{" + "name=" + name + '}';
    }  
    

    
}
