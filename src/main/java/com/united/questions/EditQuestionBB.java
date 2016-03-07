
package com.united.questions;

import com.united.view.courses.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Named("editQuestion")
@RequestScoped 
public class EditQuestionBB {

    
    private int id;
    
    @Size(min = 4, max = 20, message = "{question.name}")
    private String name;
    
    // Hopeless to validate numbers (?!?!) because, user possibly enters non-digits
    //@Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{product.price}")
    //private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "EditQuestionBB{" + "name=" + name + '}';
    }  
}
