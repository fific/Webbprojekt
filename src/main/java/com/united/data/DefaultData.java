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
import java.util.ArrayList;
import java.util.List;
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
        User l1, l2, s1, s2, s3;
        Course c;
        Moment m;
        Question q;
        Registration r;
        Answer a;
        Message me;
        Long id = 0L;

        LOG.log(Level.INFO, "*** Add default data");
        l1 = new User("teacher1", "teacher1", "teacher1", Groups.TEACHER);
        authDAO.create(l1);
        l2 = new User("teacher2", "teacher2", "teacher2", Groups.TEACHER);
        authDAO.create(l2);
        s1 = new User("student1", "student1", "student1", Groups.STUDENT);
        authDAO.create(s1);
        s2 = new User("student2", "student2", "student2", Groups.STUDENT);
        authDAO.create(s2);
        s3 = new User("student3", "student3", "student3", Groups.STUDENT);
        authDAO.create(s3);

        c = new Course("MM", "Multiplication Mathematica", 0);
        courseDAO.create(c);
        
        for (int i = 0; i < 11; i++) {
            m = new Moment("Times table " + i);
            momentDAO.create(m);
            c.addToMoments(m);
            for (int j = 0; j < 11; j++) {
                
                q = new Question(i + " * " + j);
                //System.out.println("questionid: " + id);
                questionDAO.create(q);
                m.addToQuestions(q);
                a = new Answer("" + i * j, "true");
                answerDAO.create(a);
                q.addToAnswers(a);
                
                
                /*if (i != j) {
                    q = new Question(j + " * " + i);
                    q.setId(Long.parseLong("" + j + "" + i));
                    questionDAO.create(q);
                    m.addToQuestions(q);
                    a = new Answer("" + i * j, "true");
                    answerDAO.create(a);
                    q.addToAnswers(a);
                }*/
            }
        }

        r = new Registration(l1, c);
        r.setCurrentCourse("true");
        registrationDAO.create(r);
        r = new Registration(l2, c);
        r.setCurrentCourse("true");
        registrationDAO.create(r);
        r = new Registration(s1, c);
        r.setCurrentCourse("true");
        registrationDAO.create(r);
        r = new Registration(s2, c);
        r.setCurrentCourse("true");
        registrationDAO.create(r);
        r = new Registration(s3, c);
        r.setCurrentCourse("true");
        registrationDAO.create(r);

    }

    private void clearTestData() {

    }

}
