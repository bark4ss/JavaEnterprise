package by.teachmeskills.JavaEE.controller.basic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "forwardServlet", value = "/forward-servlet")
public class RedirectServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(RedirectServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        LOGGER.log(Level.INFO, "type parameter: " + type);
        if("forward".equalsIgnoreCase(type)) {
            String path = "/forwardPage.html";
            LOGGER.log(Level.INFO, "forward path: " + path);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }
        else if("redirect".equalsIgnoreCase(type)) {
            String path = request.getContextPath() + "/redirectPage.html";
            LOGGER.log(Level.INFO, "redirect path: " + path);
            //String path = request.getContextPath() + "/notfound";
            //String path = "https://teachmeskills.by";
            response.sendRedirect(path);
        }
        else {
            String path = "/notfound";
            LOGGER.log(Level.INFO, "notfound path: " + path);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }


    }
}
