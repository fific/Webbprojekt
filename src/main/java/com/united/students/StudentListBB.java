/*package com.united.students;

import com.united.auth.AuthDAO;
import com.united.auth.User;
import java.io.Serializable;
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

    @Inject // Bad use setter or constructor injection
    private AuthDAO authDAO;

    public List<User> findRange() {
        return authDAO.findRange(currentPage * pageSize, pageSize);
    }

    @PostConstruct
    public void post() {
        count = authDAO.count();
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

}*/
