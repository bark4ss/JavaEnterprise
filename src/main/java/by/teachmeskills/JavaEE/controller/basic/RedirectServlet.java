package by.teachmeskills.JavaEE.controller.basic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "forwardServlet", value = "/forward-servlet")
public class RedirectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        if("forward".equalsIgnoreCase(type)) {
            String path = "/forwardPage.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }
        else if("redirect".equalsIgnoreCase(type)) {
            //String path = request.getContextPath() + "/redirectPage.html";
            //String path = request.getContextPath() + "/notfound";
            String path = "https://teachmeskills.by";
            response.sendRedirect(path);
        }
        else {
            String path = "/notfound";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }


    }
}
