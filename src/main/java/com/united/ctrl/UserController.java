package com.united.ctrl;


import com.united.auth.User;
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
@Named("userController")
@RequestScoped
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getSimpleName());
    private School school;
    
//    private AddUserBB addBB;
//    private EditUserBB editBB;
//    private DeleteUserBB delBB;
    
   
    public void newProduct() {
//        LOG.log(Level.INFO, "Backin bean " + addBB);
//        User p = new User(addBB.getName(), Double.valueOf(addBB.getPrice()));
//        school.getUserList().create(p);
//        List<User> ps = school.getUserList().getByName(addBB.getName());      
//        LOG.log(Level.INFO, "New value " + ps.get(0));
    }

    public void updateProduct() {
//       User p = new User(editBB.getId(), editBB.getName(), Double.valueOf(editBB.getPrice()));
//       school.getUserList().update(p);    
    }

    public void deleteProduct() {
//       String id = delBB.getId();
//       school.getUserList().delete(id);
    }

//    @Inject
//    public void setAddBB(AddUserBB addBB) {
//        this.addBB = addBB;
//    }
//    
//    @Inject
//    public void setEditBB(EditUserBB editBB) {
//        this.editBB = editBB;
//    }
//    
//    @Inject
//    public void setDelBB(DeleteUserBB delBB) {
//        this.delBB = delBB;
//    }

    @Inject
    public void setShop(SingletonSchool ss) {
        this.school = ss.getSchool();
    }

}
