/*package com.united.students;

import java.io.Serializable;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named("studentList")
@RequestScoped
public class StudentListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(StudentListBB.class.getName());

    private transient IShop shop;
    private int currentPage;
    private int pageSize = 4;  // Items on a listing (hard coded :-(  )
    private int count;

    // Must have default ctor so use setter injection
    @Inject
    public void setShop(SingletonShop ss) {
        this.shop = ss.getShop();
    }

    public List<User> findRange() {
        return authDAO.findRange(currentPage * pageSize, pageSize);
    }

    @PostConstruct
    public void post() {
        count = shop.getProductCatalogue().count();
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
