package by.teachmeskills.JavaEE.controller.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo-params")
public class RequestParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] names = req.getParameterValues("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int[] ages;
    }
}
