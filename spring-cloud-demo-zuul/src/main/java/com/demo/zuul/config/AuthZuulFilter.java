package com.demo.zuul.config;

import com.demo.commons.domain.system.Token;
import com.demo.commons.util.RedisUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthZuulFilter extends ZuulFilter {

    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

    @Autowired
    RedisUtils redisUtils;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        String url = request.getRequestURL().toString();
        boolean isStatic = url.contains("static");
        boolean isAuth = url.contains("authToken");
        // if(!isStatic && !isAuth){
        //     return true;
        // }
        // return false;
        return !isStatic && !isAuth;

    }

    @Override
    public Object run() throws ZuulException {

        String tokenStr = request.getParameter("token");
        if(!StringUtils.isEmpty(tokenStr)){
            Token token = (Token) redisUtils.getValue(tokenStr);
            if(token != null){

            }
        }
        return null;
    }
}
