package com.united.ctrl;




import com.united.auth.User;
import com.united.core.Answer;
import com.united.core.Course;
import com.united.core.Moment;
import com.united.core.Question;
import com.united.core.Registration;
import com.united.core.School;
import com.united.view.registrations.AddRegistrationBB;
import com.united.view.registrations.DeleteRegistrationBB;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 */
@Named("registrationController")
@RequestScoped
public class RegistrationController {

    private static final Logger LOG = Logger.getLogger(RegistrationController.class.getSimpleName());
    
    @Inject
    private School school;
    
    private AddRegistrationBB addBB;
    private DeleteRegistrationBB delBB;
    
   
     public void newRegistration() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
       
       Course selectedCourse = school.getCourseList().getById(addBB.getId());
       newRegistrationForSelectedCourse(u, selectedCourse);
    }
     
     public void newRegistrationForSelectedCourse(User u, Course selectedCourse) {
        List<Registration> rl = school.getRegistrationList().getAllRegistrationsForUsername();
       
       if(school.getRegistrationList().getCCForTeacher(selectedCourse).equals("true")) {
            for(Registration r : rl) {
                r.setCurrentCourse("false");
                school.getRegistrationList().update(r);
            }
            school.getRegistrationList().create(new Registration(u, selectedCourse, "true"));
       }
       else
           school.getRegistrationList().create(new Registration(u, selectedCourse));
     }
     
    //not working!!!
    public void cloneCourseRegistration() {
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map<String, Object> sessionMap = externalContext.getSessionMap();
       User u = (User) sessionMap.get("user");
       
       Course oldCourse = school.getCourseList().getById(addBB.getId());
       Course c = new Course(school.getCourseList().generatedCourseId(addBB.getId()), oldCourse.getName(), oldCourse.getVersion());
       school.getCourseList().create(c);
       
       Moment newM;
       Question newQ;
       Answer newA;
       List<Moment> newML = new ArrayList<>();
       List<Question> newQL = new ArrayList<>();
       List<Answer> newAL = new ArrayList<>();
       
       for(Moment m : oldCourse.getMoments()) {
           newM = new Moment(m.getName());
           school.getMomentList().create(newM);
           for(Question q : m.getQuestions()) {
               newQ = new Question(q.getQuestion());
               school.getQuestionList().create(newQ);
               for(Answer a : q.getAnswers()) {
                   newA = new Answer(a.getAnswer(), a.getCorrectness());
                   newAL.add(newA);
                   school.getAnswerList().create(newA);
                   newA.setQuestion(newQ);
                   school.getAnswerList().update(newA);
               }
               newQL.add(newQ);
               newQ.setMoment(m);
               newQ.setAnswers(newAL);
               newAL = new ArrayList<>();
               school.getQuestionList().update(newQ);
           }
           newML.add(newM);
           newM.setCourse(c);
           newM.setQuestions(newQL);
           newQL = new ArrayList<>();
           school.getMomentList().update(newM);
       }
       c.setMoments(newML);
       newML = new ArrayList<>();
       school.getCourseList().update(c);
       
       //Registration p = new Registration(u, c, school.getRegistrationList().getCCForTeacher(school.getCourseList().getById(addBB.getId())));
       //school.getRegistrationList().create(p);
       newRegistrationForSelectedCourse(u, c);
    }

    public void deleteRegistration() {
       Long id = delBB.getId();
       LOG.log(Level.INFO, "***DEL ID {0}", id);
       //school.getRegistrationList().deleteRegistrationById(id);
       school.getRegistrationList().delete(id);
    }

    @Inject
    public void setAddBB(AddRegistrationBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setDelBB(DeleteRegistrationBB delBB) {
        this.delBB = delBB;
    }

}
