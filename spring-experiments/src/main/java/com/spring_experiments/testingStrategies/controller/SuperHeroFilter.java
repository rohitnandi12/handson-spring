package com.spring_experiments.testingStrategies.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author moises.macero
 */
@Component
public class SuperHeroFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("X-SUPERHERO-APP", "super-header");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
