package com.united.data;

import com.united.auth.UserList;
import com.united.auth.Groups;
import com.united.auth.User;
import com.united.core.Course;
import com.united.core.CourseList;
import com.united.core.FinishedMoment;
import com.united.core.FinishedMomentList;
import com.united.core.Message;
import com.united.core.MessageList;
import com.united.core.Moment;
import com.united.core.MomentList;
import com.united.core.Question;
import com.united.core.QuestionList;
import com.united.core.Registration;
import com.united.core.RegistrationList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Puts some starting data into the database
 */
@Startup
@Singleton
public class DefaultData {

    private static final Logger LOG = Logger.getLogger(DefaultData.class.getName());

    @Inject
    private UserList authDAO;

    @Inject
    private MessageList meAuthDAO;
    
    @Inject
    private MomentList mAuthDAO;
    
    @Inject
    private CourseList cAuthDAO;
    
    @Inject
    private QuestionList qAuthDAO;
    
    @Inject
    private RegistrationList regList;
    
    @Inject
    private FinishedMomentList finMomentList;
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "*** Default data alive");
      //createTestData();   // KOMMENTERA UT första Run, dvs om inga tables finns än.
                            //Blir massa fel annars. När det finns tables i databasen, kommentera tillbaks
                            //Samma sak nere i clearTestData();
    }

    @PreDestroy
    public void destroy() {
        LOG.log(Level.INFO, "*** Default data will be destroyed");
        //clearTestData();    // KOMMENTERA UT första Run, dvs om inga tables finns än.
                            //Blir massa fel annars. När det finns tables i databasen, kommentera tillbaks
    }

    private void createTestData() {
        LOG.log(Level.INFO, "*** Add default data");
        User u = new User("qqq", "111", Groups.TEACHER);
        authDAO.create(u);
        u = new User("www", "222", Groups.STUDENT);
        authDAO.create(u);
        u = new User("test1", "222", Groups.STUDENT);
        authDAO.create(u);
        u = new User("test2", "222", Groups.TEACHER);
        authDAO.create(u);
         u = new User("test3", "222", Groups.STUDENT);
        authDAO.create(u);
        
        Moment m = new Moment("1");
        mAuthDAO.create(m);
        
        m = new Moment("2");
        mAuthDAO.create(m);
        
        m = new Moment("3");
        mAuthDAO.create(m);
        
        m = new Moment("4");
        mAuthDAO.create(m);
        
        Course c = new Course("66", "Gångertabell_1");
       
        cAuthDAO.create(c);
        
        c = new Course("67", "Gångertabell_2");
        cAuthDAO.create(c);
        
        c = new Course("68", "Gångertabell_3");
        cAuthDAO.create(c);
        
        Message me = new Message("89", "Hallå?????");
        meAuthDAO.create(me);
        
        me = new Message("87", "Någon där?????");
        meAuthDAO.create(me);
        
        me = new Message("86", "Vem?????");
        meAuthDAO.create(me);
        
        Question q = new Question(89, "0 * 5", "0");
        qAuthDAO.create(q);
        
        q = new Question(87, "1 * 5", "5");
        qAuthDAO.create(q);
        
        q = new Question(86, "2 * 5", "10");
        qAuthDAO.create(q);
        
//        Registration r = new Registration(u, c);
//        regList.create(r);
//        
//        FinishedMoment fm = new FinishedMoment(u, m);
//        finMomentList.create(fm);

    }

    private void clearTestData() {
        authDAO.delete("qqq");
        authDAO.delete("www");
        authDAO.delete("test1");
        authDAO.delete("test2");
        authDAO.delete("test3");
        
//        regList.delete(1l);
//        finMomentList.delete(2l);
        
         mAuthDAO.delete("56");
        mAuthDAO.delete("57"); 
        mAuthDAO.delete("58");
        mAuthDAO.delete("59");
        
        cAuthDAO.delete("66");
        cAuthDAO.delete("67");
        cAuthDAO.delete("68");
        
        meAuthDAO.delete("89");
        meAuthDAO.delete("87");
        meAuthDAO.delete("86");
        
        qAuthDAO.delete(89);
        qAuthDAO.delete(87);
        qAuthDAO.delete(86);
        

    }



}
