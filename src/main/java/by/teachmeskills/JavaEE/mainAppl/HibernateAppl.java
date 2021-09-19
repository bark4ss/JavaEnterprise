package by.teachmeskills.JavaEE.mainAppl;

import by.teachmeskills.JavaEE.model.*;
import by.teachmeskills.JavaEE.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class HibernateAppl {
    public static void main(String[] args) {
        UserService userService = new UserService();
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
