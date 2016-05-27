package com.united.view.parent_childs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.united.auth.User;

/**
 *
         Backing bean

 */
@Named("deleteParent_child")
@RequestScoped 
public class DeleteParent_childBB {

    private String parent;
    private String child;
    
    private Long id; //registration id
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
    
    
    
}

