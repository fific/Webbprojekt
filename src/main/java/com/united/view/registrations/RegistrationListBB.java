package com.united.view.registrations;


import com.united.core.Registration;
import com.united.core.School;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 Backing bean for the registrationList.xhtml
 
 */
@Named("registrationList")
@ViewScoped
public class RegistrationListBB implements Serializable {

    private static final Logger LOG = Logger.getLogger(RegistrationListBB.class.getName());

//    private transient School school;
    @Inject     //Is this an OK solution?
    private School school;
    
    private int currentPage;
    private int pageSize = 10;  // Items on a listing (hard coded :-(  )
    private int count;
    
    public List<Registration> findRange() {
        return school.getRegistrationList().findRange(currentPage * pageSize, pageSize);
        
    }
    
    public List<Registration> getRegistrations() {
        return school.getRegistrationList().getAllRegistrationsForUsername();
    }

    @PostConstruct
    public void post() {
        count = school.getRegistrationList().count();
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
