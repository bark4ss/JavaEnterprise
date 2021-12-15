package by.teachmeskills.JavaEE.mainAppl;

import by.teachmeskills.JavaEE.config.ApplicationConfiguration;
import by.teachmeskills.JavaEE.model.*;
import by.teachmeskills.JavaEE.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.baeldung.com/spring-tutorial
//https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html
//https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
//https://sysout.ru/rabota-s-ioc-kontejnerom-v-spring/
//http://spring-projects.ru/guides/lessons/lesson-2/
//https://habr.com/ru/post/455794/
//https://java-master.com/spring-%D0%BE%D0%B1%D0%B7%D0%BE%D1%80-%D1%84%D1%80%D0%B5%D0%B9%D0%BC%D0%B2%D0%BE%D1%80%D0%BA%D0%B0-%D0%B4%D0%BB%D1%8F-%D1%81%D0%B0%D0%BC%D1%8B%D1%85-%D0%BC%D0%B0%D0%BB%D0%B5%D0%BD%D1%8C%D0%BA%D0%B8/
//https://www.baeldung.com/constructor-injection-in-spring
//https://reflectoring.io/constructor-injection/
//https://www.youtube.com/watch?v=5ePo08sqcpk&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ
public class SpringDemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Human human1 = (Human) context.getBean("human");
        Human human11 = (Human) context.getBean("human");
        Human human2 = (Human) context.getBean("human2");
        Human human22 = (Human) context.getBean("human2");

        System.out.println(human1.getLogin());
        System.out.println(human11.getLogin());
        System.out.println(human2.getLogin());
        System.out.println(human22.getLogin());

        UserService userService = (UserService) context.getBean("userService");
        String[] projectData = { "IT Project", "Networking Project" };
        Set<Project> projects = new HashSet<>();
        for (String proj : projectData) {
            projects.add(new Project(proj));
        }
        User user = new User("Oleg",31);
        user.setProjects(projects);
        Passport passport = new Passport("123-456-789  ",user);
        user.setPassport(passport);
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
