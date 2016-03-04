package com.united.data;


import com.united.auth.Course;
import com.united.auth.CourseList;
import com.united.auth.UserList;
import com.united.auth.Groups;
import com.united.auth.Message;
import com.united.auth.MessageList;
import com.united.auth.Moment;
import com.united.auth.MomentList;
import com.united.auth.User;
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
        
        Moment m = new Moment("56");
        mAuthDAO.create(m);
        
        m = new Moment("57");
        mAuthDAO.create(m);
        
        m = new Moment("58");
        mAuthDAO.create(m);
        
        m = new Moment("59");
        mAuthDAO.create(m);
        
        Course c = new Course("66");
       
        cAuthDAO.create(c);
        
        c = new Course("67");
        cAuthDAO.create(c);
        
        c = new Course("68");
        cAuthDAO.create(c);
        
        Message me = new Message("89", "Hallå?????");
        meAuthDAO.create(me);
        
        me = new Message("87", "Någon där?????");
        meAuthDAO.create(me);
        
        me = new Message("86", "Vem?????");
        meAuthDAO.create(me);

    }

    private void clearTestData() {
        authDAO.delete("qqq");
        authDAO.delete("www");
        authDAO.delete("test1");
        authDAO.delete("test2");
        authDAO.delete("test3");
        
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
        

    }



}
