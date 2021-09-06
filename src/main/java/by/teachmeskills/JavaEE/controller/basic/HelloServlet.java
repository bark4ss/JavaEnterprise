package by.teachmeskills.JavaEE.controller.basic;

import by.teachmeskills.JavaEE.model.Person;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//https://metanit.com/java/javaee/2.1.php
//https://metanit.com/java/javaee/4.1.php
//https://javarush.ru/groups/posts/305-sozdanie-prosteyshego-web-proekta-v-intellij-idea-enterprise-edition-poshagovo-s-kartinkami
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    //private static final Logger LOGGER = LogManager.getLogger(HelloServlet.class);
    private static final Logger LOGGER = LogManager.getLogger(HelloServlet.class);
    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.log(Level.INFO,"request:");
        LOGGER.log(Level.TRACE,"trace:");
        ROOT_LOGGER.log(Level.INFO, "root_error");
        response.setContentType("text/html");
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            LOGGER.log(Level.ERROR,"catch exception");
            LOGGER.log(Level.ERROR,e);
        }


        LOGGER.log(Level.WARN, "warn-error");
        //ROOT_LOGGER.log(Level.FATAL, "root_error");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("username");
        String age = request.getParameter("userage");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] courses = request.getParameterValues("courses");

        Person person = new Person();
        person.setName(name);
        person.setAge(Integer.parseInt(age));
        person.setFlag(person.getAge() > 35);
        person.setGender(gender);
        person.setCountry(country);
        person.setCourses(Arrays.asList(courses));

        request.setAttribute("person", person);



        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/form-response.jsp");
        dispatcher.forward(request,response);



    }

    public void destroy() {
    }
}
