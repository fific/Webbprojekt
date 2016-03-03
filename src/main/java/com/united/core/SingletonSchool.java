
package com.united.core;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;


 @ApplicationScoped 
    public class SingletonSchool { 
        private School school; 
        
        
        @PostConstruct 
        private void init() { 
            school = new School();
        } 
        
        public School getSchool(){
            return school;
        }
    }
