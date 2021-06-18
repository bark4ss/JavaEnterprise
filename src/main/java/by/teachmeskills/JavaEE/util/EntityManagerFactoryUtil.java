package by.teachmeskills.JavaEE.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    //https://easyjava.ru/data/jpa/
    //https://java-master.com/%D1%80%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-jdbc-jpa-hibernate-spring-data-jpa/
    //https://www.objectdb.com/java/jpa/persistence
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactoryUtil() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("jpa-Persistence");

            } catch (Exception e) {
                throw new RuntimeException("There is issue in entityManager util");
            }
        }
        return entityManagerFactory;
    }
}
