package com.demo.zuul.config;

import com.alibaba.fastjson.JSON;
import com.demo.commons.domain.system.Permission;
import com.demo.commons.domain.system.Role;
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
import java.util.List;

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
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String URI = request.getRequestURI();
        String tokenStr = request.getParameter("token");
        if (!StringUtils.isEmpty(tokenStr)) {
            Token token = (Token) redisUtils.getValue(tokenStr);
            if (token != null) {
                List<Permission> permissions = token.getUser().getPermissions();
                int i = 1;
                for (Permission perm : permissions) {
                    //将权限字符串用addStringPermission方法授权
                    String permStr = perm.getKeyword();
                    System.out.println(permStr);
                    if (perm.getPermissionUrl().equals(URI)) {
                        return null;
                    }
                }
            }
            RequestContext.getCurrentContext().getResponse().setContentType("text/json;charset=utf-8");
            RequestContext.getCurrentContext().setSendZuulResponse(false);
            RequestContext.getCurrentContext().setResponseStatusCode(403);
            RequestContext.getCurrentContext().setResponseBody(JSON.toJSONString(ResultUtils.fail("无权访问")));
        }
        return null;
    }
}
