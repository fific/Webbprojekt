package com.united.ctrl;


import com.united.core.Course;
import com.united.core.Moment;
import com.united.core.Question;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.questions.AddQuestionBB;
import com.united.view.questions.DeleteQuestionBB;
import com.united.view.questions.EditQuestionBB;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 @author Linn
 */
@Named("questionController")
@RequestScoped
public class QuestionController {

    private static final Logger LOG = Logger.getLogger(QuestionController.class.getSimpleName());
    
    @Inject
    private School school;
    
    private AddQuestionBB addBB;
    private EditQuestionBB editBB;
    private DeleteQuestionBB delBB;
    
   
     public void newQuestion(String momentId) {
       Long momeId = Long.parseLong(momentId);

       Question q = new Question(addBB.getQuestion());
       Moment m =  school.getMomentList().getById(momeId);
       
       m.addToQuestions(q);
       school.getMomentList().update(m);
    }
     

     public void updateQuestion() {

        Long id = Long.parseLong(editBB.getId());
        Question m = school.getQuestionList().getById(id);
        //m.setAnswer(editBB.getAnswer());
        m.setQuestion(editBB.getQuestion());
        
        school.getQuestionList().update(m); 
         
    }

    public void deleteQuestion(String momentId) {
        System.out.println("momentId is: " + momentId);
        Long id = Long.parseLong(delBB.getId());
        Long momeId = Long.parseLong(momentId);

        Question m = school.getQuestionList().getById(id);
        Moment c = school.getMomentList().getById(momeId);

        c.removeQuestion(m);
        school.getMomentList().update(c);  
       
    }

    @Inject
    public void setAddBB(AddQuestionBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setEditBB(EditQuestionBB editBB) {
        this.editBB = editBB;
    }
    
    @Inject
    public void setDelBB(DeleteQuestionBB delBB) {
        this.delBB = delBB;
    }

//    @Inject
//    public void setSchool(SingletonSchool ss) {
//        this.school = ss.getSchool();
//    }

}
