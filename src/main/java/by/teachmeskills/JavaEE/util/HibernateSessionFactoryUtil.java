package by.teachmeskills.JavaEE.util;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    //https://www.baeldung.com/jpa-cascade-types
    //https://sysout.ru/tipy-cascade-primer-na-hibernate-i-spring-boot/
    //https://sysout.ru/kak-rabotaet-orphanremoval/
    //https://proselyte.net/tutorials/hibernate-tutorial/hibernate-query-language/
    //http://java-online.ru/hibernate-hql.xhtml
    //http://java-online.ru/hibernate-criteria.xhtml
    //https://www.baeldung.com/hibernate-criteria-queries
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);
                sessionFactory = configuration
                        .buildSessionFactory(new StandardServiceRegistryBuilder()
                                .build());

            } catch (Exception e) {
                throw new RuntimeException("There is issue in hibernate util");
            }
        }
        return sessionFactory;
    }
}
