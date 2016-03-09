
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

    @Size(min = 2, max = 10, message = "{course.id}")
    private String id;
    
    @Size(min = 2, max = 100, message = "{course.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "AddProductBB{" + "name=" + name + '}';
    }  
    

    
}
