package com.united.ctrl;



import com.united.core.School;
import com.united.core.SingletonSchool;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 Used for Add, Edit Delete pages

 @author Linn
 */
@Named("messageController")
@RequestScoped
public class MessageController {

    private static final Logger LOG = Logger.getLogger(MessageController.class.getSimpleName());
    private School school;
    
//    private AddMessageBB addBB;
//    private EditMessageBB editBB;
//    private DeleteMessageBB delBB;
    
   
    public void newMessage() {
//        LOG.log(Level.INFO, "Backing bean " + addBB);
//        Message p = new Message(addBB.getName(), Double.valueOf(addBB.getPrice()));
//        school.getMessageList().create(p);
//        List<Message> ps = school.getMessageList().getByName(addBB.getName());      
//        LOG.log(Level.INFO, "New value " + ps.get(0));
    }

    public void updateMessage() {
//       Message p = new Message(editBB.getId(), editBB.getName(), Double.valueOf(editBB.getPrice()));
//       school.getMessageList().update(p);    
    }

    public void deleteMessage() {
//       String id = delBB.getId();
//       school.getMessageList().delete(id);
    }

//    @Inject
//    public void setAddBB(AddMessageBB addBB) {
//        this.addBB = addBB;
//    }
//    
//    @Inject
//    public void setEditBB(EditMessageBB editBB) {
//        this.editBB = editBB;
//    }
//    
//    @Inject
//    public void setDelBB(DeleteMessageBB delBB) {
//        this.delBB = delBB;
//    }

    @Inject
    public void setSchool(SingletonSchool ss) {
        this.school = ss.getSchool();
    }

}
