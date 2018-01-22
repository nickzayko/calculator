package filterControllers;

import javax.servlet.*;
import java.io.IOException;

public class OperationMinusFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getParameter("buttonMinus").equals("")) {
            request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
            request.getRequestDispatcher("result").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
