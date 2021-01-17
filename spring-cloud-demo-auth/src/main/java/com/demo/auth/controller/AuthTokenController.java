package com.demo.auth.controller;

import com.demo.auth.service.TokenService;
import com.demo.commons.domain.system.Result;
import com.demo.commons.domain.system.Token;
import com.demo.commons.domain.system.User;
import com.demo.commons.util.RedisUtils;
import com.demo.commons.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthTokenController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/token/tokentest")
    public Result tokenTest(){
        Token token = new Token("abc",600l,"xyz",new User());
        redisUtils.storeValue("abc",token, TimeUnit.MILLISECONDS,60*60);
        Object abc = redisUtils.getValue("abc");
        System.out.println(abc);
        return ResultUtils.success(token);
    }

    @RequestMapping(value = "/token/{grantType}")
    public Result tokenRequest(@PathVariable String grantType, String username, String password){
        try{
            Token token = tokenService.authLogin(username, password);
            return ResultUtils.success(token);
        }catch (RuntimeException e){
            String errorMessage = e.getMessage();
            return ResultUtils.fail(errorMessage);
        }

    }

    @RequestMapping(value = "/token/refresh_token", method = {RequestMethod.GET, RequestMethod.POST})
    public Result refreshToken(String accessToken, String refreshToken) {
        Token token = null;
        if ((token = tokenService.refreshToken(accessToken, refreshToken)) != null) {
            return ResultUtils.success(token);
        }
        return ResultUtils.fail(token);
    }

}
