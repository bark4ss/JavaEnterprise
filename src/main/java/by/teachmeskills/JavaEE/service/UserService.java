package by.teachmeskills.JavaEE.service;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.repository.BaseDao;
import by.teachmeskills.JavaEE.repository.impl.HibernateUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private BaseDao<User> usersDao;//HibernateUserDaoImpl

    public UserService() {

    }
    @Autowired
    public UserService(@Qualifier("JPA") BaseDao<User> usersDao) {
        this.usersDao = usersDao;
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public void initM() {
        System.out.println("Service");
    }

}
