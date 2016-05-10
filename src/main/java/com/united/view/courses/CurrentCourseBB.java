/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.view.courses;

import com.united.auth.User;
import com.united.core.School;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
         Backing bean

 */
@Named("currentCourse")
@RequestScoped 
public class CurrentCourseBB {

    private String id;
    
    private String name;
    
    @Inject
    private School school;
    // Hopeless to validate numbers (?!?!) because, user possibly enters non-digits
    //@Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{product.price}")
    //private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getNameByUser() {
        if(school.getRegistrationList().getCurrentCourse() == null){
            return "";
        }
           
        else {
            return school.getRegistrationList().getCurrentCourse().getName();
        }
            
    }
    
    @Override
    public String toString() {
        return "CurrentCourseBB{" + "name=" + name + '}';
    }  
}

