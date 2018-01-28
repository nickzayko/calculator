package filterControllers;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public abstract class SuperClassFilter implements Filter {
    public String parameterFromRequest;

//    public String getParameterFromRequest(String parameterFromRequest) {
//        return this.parameterFromRequest = parameterFromRequest;
//    }
//
//    public void setParameterFromRequest(String parameterFromRequest) {
//        this.parameterFromRequest = parameterFromRequest;
//    }

//    public SuperClassFilter(String parameterFromRequest) {
//        this.parameterFromRequest = parameterFromRequest;
//    }

    public SuperClassFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (getParameterFromRequest(request).equals("")) {
            request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
            request.getRequestDispatcher("result").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }

    public abstract String getParameterName();

    public String getParameterFromRequest(ServletRequest httpServletRequest) {
        return httpServletRequest.getParameter(getParameterName());
    }

}
