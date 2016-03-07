package com.united.ctrl;





import com.united.core.Question;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.questions.AddQuestionBB;
import com.united.questions.DeleteQuestionBB;
import com.united.questions.EditQuestionBB;
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
    
   
     public void newQuestion() {
       LOG.log(Level.INFO, "Backing bean " + addBB);
       Question p = new Question(addBB.getId(), addBB.getQuestion(), addBB.getAnswer());
        school.getQuestionList().create(p);
    }

     public void updateQuestion() {
       Question p = new Question(editBB.getId(), editBB.getQuestion(), editBB.getAnswer());
       school.getQuestionList().update(p);    
    }

    public void deleteQuestion() {
       int id = delBB.getId();
       school.getQuestionList().delete(id);
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
