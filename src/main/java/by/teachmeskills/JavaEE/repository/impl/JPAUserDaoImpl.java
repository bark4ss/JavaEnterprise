package by.teachmeskills.JavaEE.repository.impl;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.repository.BaseDao;
import by.teachmeskills.JavaEE.config.EntityManagerFactoryUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("JPA")
public class JPAUserDaoImpl implements BaseDao<User> {
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
        System.out.println(user.getId());
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
    public List<User> findAll() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        List<User> users = (List<User>)em.createNamedQuery("User.findAll").getResultList();
        em.close();
        return users;
    }
}
