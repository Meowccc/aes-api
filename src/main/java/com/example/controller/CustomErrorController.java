package com.example.controller;

import com.example.constant.WebConstants;
import com.example.exception.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @create 2021 - 03 - 05 上午 11:34
 **/
@RestController
public class CustomErrorController{

//    @Resource
//    private HttpServletRequest request;


    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @GetMapping("/error/throw")
    public void errorThrow(HttpServletRequest request) throws Exception {
        throw (Exception) request.getAttribute(WebConstants.FILTER_ERROR);
    }

//    @Override
//    public String getErrorPath() {
//        return "/error/throw";
//    }


//    @Override
//    public String getErrorPath() {
//        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//        globalExceptionHandler.handleException(exception);
//    }
}
