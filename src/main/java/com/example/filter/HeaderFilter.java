package com.example.filter;

import com.example.exception.NotAuthorizedException;
import com.example.exception.TimeoutException;
import com.example.token.SecurityHelper;
import com.example.token.TokenPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author
 * @create 2021 - 03 - 03 下午 04:07
 **/
@Component
public class HeaderFilter extends OncePerRequestFilter {

    @Autowired
    SecurityHelper securityHelper;

    @Value("${token.expireTime}")
    private long limit;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();

        String encrypted = Optional.ofNullable(request.getHeader("Authorization")).orElseThrow(() -> new NotAuthorizedException(" no token ")).substring(7);
        String decrypted = securityHelper.decrypt(encrypted);

        TokenPayload tokenPayload = TokenPayload.parseJson(decrypted);
        if (!tokenPayload.isValid(limit)) throw new TimeoutException();
//        try {
////            String encrypted = request.getHeader("Authorization").substring(7);
//            String encrypted = Optional.ofNullable(request.getHeader("Authorization")).orElseThrow(() -> new NotAuthorizedException(" no token ")).substring(7);
//            String decrypted = securityHelper.decrypt(encrypted);
//
//            TokenPayload tokenPayload = TokenPayload.parseJson(decrypted);
//            if (!tokenPayload.isValid(limit)) throw new TimeoutException();
//
//        } catch (Exception e) {
//            // 將 filter 的 exception 拋到 controller 處理
//            request.setAttribute("filter.error", e);
//            request.getRequestDispatcher("/error/throw").forward(request, response);
//        }

        chain.doFilter(request, response);
        long processTime = System.currentTimeMillis() - startTime;
        System.out.println(processTime + " ms");
    }
}
