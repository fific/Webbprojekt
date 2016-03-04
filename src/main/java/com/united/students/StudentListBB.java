package com.united.students;

import com.united.auth.User;
import com.united.auth.UserList;
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

@Named("studentList")
@RequestScoped
public class StudentListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(StudentListBB.class.getSimpleName());
    private static final long serialVersionUID = 1L;

    private String id;
    private String password;
    private int currentPage;
    private int pageSize = 4;  // Items on a listing (hard coded :-(  )
    private int count;
    
    @Inject
    private UserList users;

    public List<User> findRange() {
        return users.findRange(currentPage * pageSize, pageSize);
    }

    @PostConstruct
    public void post() {
        count = users.count();
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
