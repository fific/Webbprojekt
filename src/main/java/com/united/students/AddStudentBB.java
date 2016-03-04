package com.united.students;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("addStudent")
@RequestScoped 
public class AddStudentBB {
    
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{student.id}")
    private String id;
    
    @Size(min = 4, max = 20, message = "Använd mellan 4 och 20 tecken.")
    private String name;
    
    // Hopeless to validate numbers (?!?!) because, user possibly enters non-digits
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{student.passwd}")
    private String password;

    @Override
    public String toString() {
        return "AddStudentBB{" /*+ "id=" + id*/ + "name=" + name + ", passwd=" + password + '}';
    }  
    
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
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
