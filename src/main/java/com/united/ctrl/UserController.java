package com.united.ctrl;


import com.united.auth.LoginBean;
import com.united.auth.User;
import com.united.core.School;
import com.united.core.SingletonSchool;
import com.united.view.users.AddUserBB;
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

    @Inject
    private School school;
    
    
    private AddUserBB addBB;
//    private EditUserBB editBB;
//    private DeleteUserBB delBB;
    
   
    public void newUser() {
        User p = new User(addBB.getId(), addBB.getPasswd(), addBB.getGroups());
        school.getUserList().create(p);
        //Tried to login on new user as well
        //loginB.login();
    }

    public void updateUser() {
//       User p = new User(editBB.getId(), editBB.getName(), Double.valueOf(editBB.getPrice()));
//       school.getUserList().update(p);    
    }

    public void deleteUser() {
//       String id = delBB.getId();
//       school.getUserList().delete(id);
    }

    @Inject
    public void setAddBB(AddUserBB addBB) {
        this.addBB = addBB;
    }
    
//    @Inject
//    public void setEditBB(EditUserBB editBB) {
//        this.editBB = editBB;
//    }
//    
//    @Inject
//    public void setDelBB(DeleteUserBB delBB) {
//        this.delBB = delBB;
//    }

//    @Inject
//    public void setSchool(SingletonSchool ss) {
//        this.school = ss.getSchool();
//    }
    
    public List<User> getStudentList() {
        return school.getUserList().getAllStudents();
    }
    
    public int countStudentList() {
        return school.getUserList().getAllStudents().size();
    }
    
    public List<User> getTeacherList() {
        return school.getUserList().getAllTeachers();
    }

}
