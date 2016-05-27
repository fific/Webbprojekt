/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.view.parent_childs;

import com.united.core.Parent_childList;
import com.united.core.Question;
import com.united.core.QuestionList;
import com.united.core.School;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.united.auth.User;

/**
 *
 * @author Jenny
 */
@Named("parent_child")
@ViewScoped
public class Parent_childBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(Parent_childBB.class.getName());

    @Inject
    private School school;
    
    private String parentId;
    private String childId;
    private String id;
   
    
    @Inject
    private Parent_childList parent_childList;
    

    public User findParent(User child) {
        return parent_childList.getAllParentsForChild(child).get(0).getParent();
    }
    
    public User findChild(User parent) {
        return parent_childList.getAllParent_ChildForParent(parent).get(0).getParent();
    }
}