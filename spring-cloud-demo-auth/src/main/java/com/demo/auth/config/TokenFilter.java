package com.demo.auth.config;

import com.alibaba.fastjson.JSON;
import com.demo.commons.util.ResultUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String url = httpServletRequest.getRequestURL().toString();
        String grantType = url.substring(url.lastIndexOf("/")+1);
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        if(!url.contains("/auth/token")){
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtils.notFound()));
        }else if(!grantType.equals("password") && grantType.equals("code")){
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtils.grantTypeError()));
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
