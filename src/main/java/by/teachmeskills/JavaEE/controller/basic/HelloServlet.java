package by.teachmeskills.JavaEE.controller.basic;

import java.io.*;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String name = request.getParameter("username");
            String age = request.getParameter("userage");
            String gender = request.getParameter("gender");
            String country = request.getParameter("country");
            String[] courses = request.getParameterValues("courses");
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Age: " + age + "</p>");
            writer.println("<p>Gender: " + gender + "</p>");
            writer.println("<p>Country: " + country + "</p>");
            writer.println("<h4>Courses</h4>");
            for (String course : courses)
                writer.println("<li>" + course + "</li>");
        }
    }

    public void destroy() {
    }
}
