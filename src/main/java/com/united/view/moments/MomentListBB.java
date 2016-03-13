/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.united.view.moments;

import com.united.auth.User;
import com.united.auth.UserList;
import com.united.core.Course;
import com.united.core.CourseList;
import com.united.core.Moment;
import com.united.core.MomentList;
import com.united.core.School;
import com.united.core.SingletonSchool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("momentList")
@RequestScoped
public class MomentListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(MomentListBB.class.getSimpleName());
    private static final long serialVersionUID = 1L;

    private String courseId;
    private String id;
    private String name;
    private int currentPage;
    private int pageSize = 10;  // Items on a listing (hard coded :-(  )
    private int count;
    
    @Inject
    private MomentList moments;
    
    @Inject
    private CourseList courses;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Moment> findRange() {
        Course selectedCourse = courses.getById(courseId);
        return selectedCourse.getMoments();
//        return moments.findRange(currentPage * pageSize, pageSize);
    }

    @PostConstruct
    public void post() {
        count = moments.count();
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

}

