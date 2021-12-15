package by.teachmeskills.JavaEE.config;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.Human;
import by.teachmeskills.JavaEE.model.User;
import by.teachmeskills.JavaEE.postprocessor.BeanPostProcessorEx;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "by.teachmeskills.JavaEE")
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    //https://sysout.ru/rabota-s-ioc-kontejnerom-v-spring/
    //https://proselyte.net/tutorials/spring-tutorial-full-version/introduction/

    @Bean
    @Scope(scopeName = "prototype")
    public Human human() {
        Random r = new Random();
        Human human = new Human();
        human.setLogin("login" + r.nextInt(10));
        return human;
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Human human2() {
        Random r = new Random();
        Human human = new Human();
        human.setLogin("login" + r.nextInt(10));
        return human;
    }

    @Bean
    public BeanPostProcessorEx beanPostProcessorEx() {
        return new BeanPostProcessorEx();
    }

    @Bean
    public Auto tesla() {
        Auto tesla = new Auto();
        tesla.setColor("white");
        tesla.setModel("tesla");
        return tesla;
    }

}
