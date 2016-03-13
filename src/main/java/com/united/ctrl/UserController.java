package com.united.ctrl;


import com.united.auth.Groups;
import com.united.auth.User;
import com.united.core.School;
import com.united.view.users.AddUserBB;
import com.united.view.users.DeleteUserBB;
import com.united.view.users.EditUserBB;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    private EditUserBB editBB;
    private DeleteUserBB delBB;
    
   
    public void newUser() {
        System.out.println("-------getId: " + addBB.getId() + ". getName: " + addBB.getName());
        User p = new User(addBB.getId(), addBB.getPasswd(), addBB.getName(), addBB.getGroups());
        school.getUserList().create(p);
    }

    public void updateUser() {
       User p = new User(editBB.getId(), editBB.getPassword(), editBB.getName(), editBB.getGroups());
       school.getUserList().update(p);    
    }
    
    public void updateStudent() {
       User p = new User(editBB.getId(), editBB.getPassword(), editBB.getName(), Groups.STUDENT);
       school.getUserList().update(p);    
    }
    
    public void updateTeacher() {
        User p = new User(editBB.getId(), editBB.getPassword(), editBB.getName(), Groups.TEACHER);
        school.getUserList().update(p);    
    }
    
    public void updateCurrentUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        User user = (User) externalContext.getSessionMap().get("user");
        
        User p = new User(user.getId(), user.getPasswd(), user.getName(), user.getGroups().get(0));
        school.getUserList().update(p);    
    }

    public void deleteUser() {
       String id = delBB.getId();
       school.getUserList().delete(id);
    }

    @Inject
    public void setAddBB(AddUserBB addBB) {
        this.addBB = addBB;
    }
    
    @Inject
    public void setEditBB(EditUserBB editBB) {
        this.editBB = editBB;
    }
    
    @Inject
    public void setDelBB(DeleteUserBB delBB) {
        this.delBB = delBB;
    }

//    @Inject
//    public void setSchool(SingletonSchool ss) {
//        this.school = ss.getSchool();
//    }
    
    public List<User> getStudentList() {
        return school.getUserList().getAllStudents();
    }
        
    public List<User> getTeacherList() {
        return school.getUserList().getAllTeachers();
    }
    
    public int countStudents() {
        return getStudentList().size();
    }
    
    public int countUsers() {
        return school.getUserList().count();
    }
    
    public int countTeachers() {
        return getTeacherList().size();
    }


}
