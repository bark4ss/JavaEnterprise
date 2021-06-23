package by.teachmeskills.JavaEE.repository;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Auto findAutoById(int id);
    List<User> findAll();
}
