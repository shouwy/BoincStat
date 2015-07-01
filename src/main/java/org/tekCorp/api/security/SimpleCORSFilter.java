package org.tekCorp.api.security;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Inspiron on 29/06/2015.
 */
@Component
public class SimpleCORSFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response =  (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        filterChain.doFilter(request, res);
    }

    @Override
    public void destroy() {  }

    public void init(FilterConfig filterConfig){ }

}
