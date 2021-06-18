package by.teachmeskills.JavaEE.repository.impl;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.repository.UserDao;
import by.teachmeskills.JavaEE.util.EntityManagerFactoryUtil;
import by.teachmeskills.JavaEE.util.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class JPAUserDaoImpl implements UserDao {
    @Override
    public User findById(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public void save(User user) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(User user) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(User user) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Auto findAutoById(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Auto auto = em.find(Auto.class, id);
        em.close();
        return auto;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        List<User> users = (List<User>)em.createQuery("FROM User").getResultList();
        em.close();
        return users;
    }
}
