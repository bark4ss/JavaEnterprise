package by.teachmeskills.JavaEE.mainAppl;

import by.teachmeskills.JavaEE.config.ApplicationConfiguration;
import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class HibernateAppl {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("Oleg",31);
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
