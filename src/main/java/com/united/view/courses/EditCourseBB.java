
package com.united.view.courses;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Named("editCourse")
@RequestScoped 
public class EditCourseBB {

    
    private Long id;
    
    @Size(min = 4, max = 20, message = "{course.name}")
    private String name;
    
    // Hopeless to validate numbers (?!?!) because, user possibly enters non-digits
    //@Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{product.price}")
    //private String price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "EditProductBB{" + "name=" + name + '}';
    }  
}
