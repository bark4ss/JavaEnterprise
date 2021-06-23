package by.teachmeskills.JavaEE.config;

import by.teachmeskills.JavaEE.model.Auto;
import by.teachmeskills.JavaEE.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "by.teachmeskills.JavaEE")
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

}
