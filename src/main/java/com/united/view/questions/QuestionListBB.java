package com.united.view.questions;



import com.united.core.CourseList;
import com.united.core.MomentList;
import com.united.core.Question;
import com.united.core.QuestionList;
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
    private String momentId;
    private String id;
    private String name;
    
    @Inject
    private MomentList moments;
    
    @Inject
    private QuestionList questions;

public String getMomentId() {
        return momentId;
    }

    public void setMomentId(String momentId) {
        this.momentId = momentId;
    }

    public List<Question> findRange() {
        return school.getQuestionList().findRange(currentPage * pageSize, pageSize);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
