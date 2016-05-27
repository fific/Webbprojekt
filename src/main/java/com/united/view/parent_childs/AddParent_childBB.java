
package com.united.view.parent_childs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import com.united.auth.User;

@Named("addParent_child")
@RequestScoped 
public class AddParent_childBB {

    @Size(min = 1, max = 100, message = "{parent_child.id}")
    private String id;
    
    @Size(min = 1, max = 100, message = "{parent_child.parent}")
    private String parent;
    
    @Size(min = 1, max = 100, message = "{parent_child.child}")
    private String child;
    

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
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    // onödig
    @Override
    public String toString() {
        return "AddParent_childBB{" + "parent=" + parent + '}';
    }  
    
}
