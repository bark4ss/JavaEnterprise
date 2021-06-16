package by.teachmeskills.JavaEE.mainAppl;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.service.UserService;

public class HibernateAppl {
    //https://www.baeldung.com/jpa-cascade-types
    //https://sysout.ru/tipy-cascade-primer-na-hibernate-i-spring-boot/
    //https://sysout.ru/kak-rabotaet-orphanremoval/
    //https://proselyte.net/tutorials/hibernate-tutorial/hibernate-query-language/
    //http://java-online.ru/hibernate-hql.xhtml
    //http://java-online.ru/hibernate-criteria.xhtml
    //https://www.baeldung.com/hibernate-criteria-queries
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("Dima",36);
        userService.saveUser(user);
        Auto ferrari = new Auto("Tesla", "white");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto bugatti = new Auto("Bugatti", "blue");
        bugatti.setUser(user);
        user.addAuto(bugatti);
        userService.updateUser(user);
        userService.findAllUsers().forEach(System.out::println);
    }
}
