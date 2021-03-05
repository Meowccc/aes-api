package com.example.filter;

import com.example.constant.WebConstants;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author
 * @create 2021 - 03 - 05 下午 01:21
 **/
@Component
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("exception filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{

            if(Objects.isNull(request.getAttribute(WebConstants.FILTER_ERROR))) chain.doFilter(request, response);
            else throw (Exception) request.getAttribute(WebConstants.FILTER_ERROR);
        } catch (Exception e){
            request.setAttribute(WebConstants.FILTER_ERROR, e);
            request.getRequestDispatcher("/error/throw").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
