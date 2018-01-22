package models;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getAttribute("buttonPlus") == null){
            request.setAttribute("informationLabel", "Error!");
            request.getRequestDispatcher("result").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
