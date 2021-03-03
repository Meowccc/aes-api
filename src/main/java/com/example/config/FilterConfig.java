package com.example.config;

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
    HeaderFilter headerFilter;

    @Bean
    public FilterRegistrationBean<HeaderFilter> requestHeaderFilter(){
        FilterRegistrationBean<HeaderFilter>bean = new FilterRegistrationBean<>();
        bean.setFilter(headerFilter);
        bean.addUrlPatterns("/*");
        bean.setName("headerFilter");
        return bean;
    }
}
