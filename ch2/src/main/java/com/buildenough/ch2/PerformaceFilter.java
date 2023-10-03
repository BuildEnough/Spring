package com.buildenough.ch2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class PerformaceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        filterChain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        System.out.print("[" + ((HttpServletRequest)request).getRequestURI() + "]");
        System.out.println(" time=" + (endTime - startTime));
    }
}
