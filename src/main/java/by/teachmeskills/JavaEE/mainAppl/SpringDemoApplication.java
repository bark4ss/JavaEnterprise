package by.teachmeskills.JavaEE.mainAppl;

import by.teachmeskills.JavaEE.config.ApplicationConfiguration;
import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
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
        UserService userService = (UserService) context.getBean("userService");
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
