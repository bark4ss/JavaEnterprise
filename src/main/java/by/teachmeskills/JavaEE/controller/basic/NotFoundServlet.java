package by.teachmeskills.JavaEE.controller.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notfound")
public class NotFoundServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            String type = request.getParameter("type");
            writer.println("<h2>Type is incompatible : " + type + "</h2>");
        }
    }
}
