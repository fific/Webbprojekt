package com.united.data;

import com.united.auth.UserList;
import com.united.auth.Groups;
import com.united.auth.User;
import com.united.core.Answer;
import com.united.core.AnswerList;
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
    private MessageList messageDAO;
    
    @Inject
    private MomentList momentDAO;
    
    @Inject
    private CourseList courseDAO;
    
    @Inject
    private QuestionList questionDAO;
    
    @Inject
    private RegistrationList registrationDAO;
    
    @Inject
    private AnswerList answerDAO;
    
    @Inject
    private FinishedMomentList finMomentDAO;
    
    @PostConstruct
    public void post() {
        LOG.log(Level.INFO, "*** Default data alive");
      createTestData();   // KOMMENTERA UT första Run, dvs om inga tables finns än.
                            //Blir massa fel annars. När det finns tables i databasen, kommentera tillbaks
                            //Samma sak nere i clearTestData();
    }

    @PreDestroy
    public void destroy() {
        LOG.log(Level.INFO, "*** Default data will be destroyed");
        clearTestData();    // KOMMENTERA UT första Run, dvs om inga tables finns än.
                            //Blir massa fel annars. När det finns tables i databasen, kommentera tillbaks
    }

    private void createTestData() {
        User u;
        Course c;
        Moment m;
        Question q;
        Registration r;
        Answer a;
        Message me;
        
        LOG.log(Level.INFO, "*** Add default data");
        u = new User("lärare1", "lärare1", "lärare1", Groups.TEACHER);
        authDAO.create(u);
        u = new User("lärare2", "lärare2","lärare2", Groups.TEACHER);
        authDAO.create(u);
        u = new User("student1", "student1","student1", Groups.STUDENT);
        authDAO.create(u);
        u = new User("student2", "student2","student2", Groups.STUDENT);
        authDAO.create(u);
        u = new User("student3", "student3","student3", Groups.STUDENT);
        authDAO.create(u);
        
        c = new Course("SV1", "Svenska 1");
        courseDAO.create(c);
        m = new Moment("Verb");
        momentDAO.create(m);
        c.addToMoments(m);
        m = new Moment("Tempus");
        momentDAO.create(m);
        c.addToMoments(m);
        
        c = new Course("HI1", "Historia 1");
        courseDAO.create(c);
        m = new Moment("Apartheid");
        c.addToMoments(m);
        
        r = new Registration(u,c);
        registrationDAO.create(r);
        
        c = new Course("MA1", "Matematik 1");
        courseDAO.create(c);
        m = new Moment("Multiplikation");
        c.addToMoments(m);
        /*q = new Question("1*1");
        m.addToQuestions(q);
        q = new Question("1*2");
        m.addToQuestions(q);
        q = new Question("5*5");
        m.addToQuestions(q);*/
//        Moment m = new Moment("1");
//        momentDAO.create(m);
//        
//        m = new Moment("2");
//        momentDAO.create(m);
//        
//        m = new Moment("3");
//        momentDAO.create(m);
//        
//        m = new Moment("4");
//        momentDAO.create(m);
        
        c = new Course("GGR1", "Gångertabell_1");
        courseDAO.create(c);
        
        c = new Course("67", "Gångertabell_2");
        courseDAO.create(c);
        
        c = new Course("68", "Gångertabell_3");
        courseDAO.create(c);
        

        
        /*q = new Question("0 * 5");
        questionDAO.create(q);
        
        
        q = new Question("1 * 5");
        questionDAO.create(q);
        
        q = new Question("2 * 5");
        questionDAO.create(q);
        */
        me = new Message("89", "Hallå?????");
        messageDAO.create(me);
        
        me = new Message("87", "Någon där?????");
        messageDAO.create(me);
        
        me = new Message("86", "Vem?????");
        messageDAO.create(me);
        
//        Registration r = new Registration(u, c);
//        registrationDAO.create(r);
//        
//        FinishedMoment fm = new FinishedMoment(u, m);
//        finMomentDAO.create(fm);

    }

    private void clearTestData() {
        authDAO.delete("lärare1");
        authDAO.delete("lärare2");
        authDAO.delete("student1");
        authDAO.delete("student2");
        authDAO.delete("student3");
        
//        registrationDAO.delete(1l);
//        finMomentDAO.delete(2l);
        

        
        momentDAO.delete(momentDAO.getById(1l).getId());
        momentDAO.delete(momentDAO.getById(2l).getId());
        momentDAO.delete(momentDAO.getById(3l).getId());
        momentDAO.delete(momentDAO.getById(4l).getId());
        
        courseDAO.delete("66");
        courseDAO.delete("67");
        courseDAO.delete("68");
        
        messageDAO.delete("89");
        messageDAO.delete("87");
        messageDAO.delete("86");
        
        questionDAO.delete(89);
        questionDAO.delete(87);
        questionDAO.delete(86);
        

    }



}
