package com.demo.zuul.config;

import com.alibaba.fastjson.JSON;
import com.demo.commons.domain.system.Token;
import com.demo.commons.domain.system.User;
import com.demo.commons.util.RedisUtils;
import com.demo.commons.util.ResultUtils;
import com.demo.zuul.service.daoserverfeignservice.RoleService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNullFormatVisitor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthZuulFilter extends ZuulFilter {



    @Autowired
    RedisUtils redisUtils;
    @Autowired
    RoleService roleService;

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
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String url = request.getRequestURL().toString();
        boolean isStatic = url.contains("static");
        boolean isAuth = url.contains("authToken");
        // boolean isDao = url.contains("dao");
        // if(!isStatic && !isAuth){
        //     return true;
        // }
        // return false;
        return !isStatic && !isAuth;

    }

    @Override
    public Object run() throws ZuulException {
        HttpServletResponse httpServletResponse = RequestContext.getCurrentContext().getResponse();
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String tokenStr = request.getParameter("token");
        if(!StringUtils.isEmpty(tokenStr)){
            Token token = (Token) redisUtils.getValue(tokenStr);
            if(token != null){
                User user = token.getUser();
                // TODO访问数仓判断当前role是否可以访问该接口
                Boolean isPermit = (Boolean) roleService.isPermit(user.getUserName()).getData();
                if(isPermit) RequestContext.getCurrentContext().setSendZuulResponse(false);
                return null;
            }
        }
        RequestContext.getCurrentContext().setSendZuulResponse(false);
        httpServletResponse.setStatus(403);
        // httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtils.fail("没有权限")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestContext.getCurrentContext().setResponse(httpServletResponse);
        return null;
    }
}
