package com.nhnacademy.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "counterFilter", urlPatterns = "/*")
public class CounterFilter implements Filter {
    static int counter;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        ServletContext servletContext = request.getServletContext();
        counter = (int) servletContext.getAttribute("counter");
        servletContext.setAttribute("counter", ++counter);

        chain.doFilter(request, response);
    }

}
