package com.example.config;

import com.example.filter.ErrorFilter;
import com.example.filter.HeaderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @create 2021 - 03 - 03 下午 04:14
 **/
@Configuration
public class FilterConfig {

    @Autowired
    private HeaderFilter headerFilter;

    @Autowired
    private ErrorFilter errorFilter;

    @Bean
    public FilterRegistrationBean<ErrorFilter> registerErrorFilter(){
        FilterRegistrationBean<ErrorFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(errorFilter);
        bean.addUrlPatterns("/test","/PdfService/*");
        bean.setName("errorFilter");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<HeaderFilter> registerHeaderFilter(){
        FilterRegistrationBean<HeaderFilter>bean = new FilterRegistrationBean<>();
        bean.setFilter(headerFilter);
        bean.addUrlPatterns("/test","/PdfService/*");
        bean.setName("headerFilter");
        return bean;
    }


}
