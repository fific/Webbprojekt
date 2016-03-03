
package com.united.view.courses;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
         Backing bean

 */
@Named("addCourse")
@RequestScoped 
public class AddCourseBB {

    @Size(min = 4, max = 20, message = "{course.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Hopeless to validate numbers (?!?!) because, user possibly enters non-digits
    //@Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{product.price}")
    //private String price;

    @Override
    public String toString() {
        return "AddProductBB{" + "name=" + name + '}';
    }  
    

    
}
