package by.teachmeskills.JavaEE.aop;

import by.teachmeskills.JavaEE.controller.basic.RedirectServlet;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class Logging {
    //https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html
    //https://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
    //https://habr.com/ru/post/428548/
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Pointcut("execution(public * by.teachmeskills.JavaEE.service.*.*(..))")
    public void selectAllMethodsAvailable() {

    }

    @Before("selectAllMethodsAvailable()")
    public void beforeAdvice() {
        LOGGER.log(Level.INFO, "Now we are going to initiate.");
    }

    @After("selectAllMethodsAvailable()")
    public void afterAdvice() {
        LOGGER.log(Level.INFO, "Has been initiated.");
    }

    @AfterReturning(pointcut = "selectAllMethodsAvailable()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        LOGGER.log(Level.INFO, "Value: " + someValue);
    }

    @Around("selectAllMethodsAvailable()")
    public Object aroundCallAt(ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch(call.toString());
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
