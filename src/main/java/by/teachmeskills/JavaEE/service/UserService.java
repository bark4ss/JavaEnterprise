package by.teachmeskills.JavaEE.service;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.repository.UserDao;
import by.teachmeskills.JavaEE.repository.impl.HibernateUserDaoImpl;
import by.teachmeskills.JavaEE.repository.impl.JPAUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private UserDao usersDao;//HibernateUserDaoImpl

    public UserService() {

    }
    @Autowired
    public UserService(@Qualifier("JPA") UserDao usersDao) {
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

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }
}
