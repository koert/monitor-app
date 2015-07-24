package nl.zencode.monitor.security;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Servlet filter to manage authentication context.
 * @author Koert Zeilstra
 */
@WebFilter("/service/*")
public class AuthenticationFilter implements Filter {

    @Inject
    private AuthenticationContext authenticationContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter start");
        try {
            chain.doFilter(request, response);
        } finally {
            System.out.println("doFilter stop");
        }

    }

    @Override
    public void destroy() {
    }
}
