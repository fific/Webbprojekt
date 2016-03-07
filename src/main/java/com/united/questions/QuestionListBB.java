package com.united.questions;


import com.united.view.courses.*;
import com.united.core.Course;
import com.united.core.CourseList;
import com.united.core.Question;
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


@Named("questionList")
@ViewScoped
public class QuestionListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(QuestionListBB.class.getName());

//    private transient School school;
    @Inject     //Is this an OK solution?
    private School school;
    
    private int currentPage;
    private int pageSize = 10;  // Items on a listing (hard coded :-(  )
    private int count;



    public List<Question> findRange() {
        return school.getQuestionList().findRange(currentPage * pageSize, pageSize);
    }

    @PostConstruct
    public void post() {
        count = school.getQuestionList().count();
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
