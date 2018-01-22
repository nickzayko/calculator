package filterControllers;

import javax.servlet.*;
import java.io.IOException;

public class OperationPlusFilter implements javax.servlet.Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getParameter("buttonPlus").equals("")) {
            request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
            request.getRequestDispatcher("result").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }


    public void destroy() {

    }
}
