package com.united.view.courses;

import com.united.auth.Course;
import com.united.core.School;
import com.united.core.SingletonSchool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 Backing bean for the courseList.xhtml
 
 */
@Named("courseList")
@ViewScoped
public class CourseListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(CourseListBB.class.getName());

    private transient School school;
    private int currentPage;
    private int pageSize = 10;  // Items on a listing (hard coded :-(  )
    private int count;

    // Must have default ctor so use setter injection
    @Inject
    public void setSchool(SingletonSchool s) {
        this.school = s.getSchool();
    }

    public List<Course> findRange() {
        //return school.getCourseList().findRange(currentPage * pageSize, pageSize);
        return new ArrayList<>();
    }

    @PostConstruct
    public void post() {
        //count = school.getCourseList().count();
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
