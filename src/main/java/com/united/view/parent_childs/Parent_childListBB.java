package com.united.view.parent_childs;

import com.united.auth.User;
import com.united.core.Parent_child;
import com.united.core.School;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.logging.Level;

/**
 Backing bean for the registrationList.xhtml
 
 */
@Named("parent_childList")
@ViewScoped
public class Parent_childListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(Parent_childListBB.class.getName());
    
    private String parentid;
    private String parentname;
    
    private String childid;
    private String childname;

//    private transient School school;
    @Inject     //Is this an OK solution?
    private School school;
    
    private int currentPage;
    private int pageSize = 10;  // Items on a listing (hard coded :-(  )
    private int count;
    
   /* public List<Parent_child> findRange() {
        return school.getParent_childList().findRange(currentPage * pageSize, pageSize);
        
    }*/
    
    public List<Parent_child> getAllParents() {// mycket skum!!
        
                LOG.log(Level.INFO, "Parent_childListBB getAllParents kördes");
            return null;
        //school.getParent_childList().getAllParent_childForChild();
    }
    
    public List<Parent_child> getParents() {
        return school.getParent_childList().getAllParentsForChild();
    }
     public List<Parent_child> getChildren() {
        return school.getParent_childList().getAllChildrenForParent();
    }
    public List<Parent_child> getParents(String userid) {// kanske ska bytas och bli tvärt om med den nedanför, den nedanför hämtar föräldrar och denna hämtar barn???? 
        LOG.log(Level.INFO, "Parent_childListBB getParents(String userid) kördes");
            //return null;
 
        return school.getParent_childList().getAllParent_ChildForParent(school.getUserList().getById(userid));
    }
    
    public List<Parent_child> getChildren(String userid) {
        LOG.log(Level.INFO, "Parent_childListBB getChildren(String userid) kördes");
            //return null;
        
        return school.getParent_childList().getAllParentsForChild(school.getUserList().getById(userid));
    }

    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "Parent_childListBB post kördes");
        count = school.getParent_childList().count();
    }

    public void next() {
        if (currentPage < (count / pageSize)) {
            currentPage = currentPage + 1;
        }
    }

    public void prev() {
        if (currentPage > 0) {
            currentPage = currentPage - 1;
        }
    }
        public void setParentid(String userid) {
        this.parentid = userid;
    }
    
    public String getParentid() {
        return parentid;
    }
    
    public void setParentname(String parentname) {
        this.parentname = parentname;
    }
    
    public String getParentname() {
        return parentname;
    }
    public void setChildid(String userid) {
        this.childid = userid;
    }
    
    public String getChildid() {
        return childid;
    }
    
    public void setChlildname(String childname) {
        this.childname = childname;
    }
    
    public String getchildname() {
        return childname;
    }

}

