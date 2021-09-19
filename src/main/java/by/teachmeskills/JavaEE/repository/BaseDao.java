package by.teachmeskills.JavaEE.repository;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;

import java.util.List;

public interface BaseDao<T> {

    T findById(int id);
    void save(T user);
    void update(T user);
    void delete(T user);
    List<T> findAll();
}
