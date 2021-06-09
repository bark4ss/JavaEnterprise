package by.teachmeskills.JavaEE.filter;

import by.teachmeskills.JavaEE.controller.basic.HelloServlet;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(EncodingFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        LOGGER.log(Level.ALL, "standartCharset:" + StandardCharsets.UTF_8.displayName());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
