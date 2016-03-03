package com.united.data;


import com.united.auth.UserList;
import com.united.auth.Groups;
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

    }

    private void clearTestData() {
        authDAO.delete("qqq");
        authDAO.delete("www");
        authDAO.delete("test1");
        authDAO.delete("test2");
        authDAO.delete("test3");

    }



}
