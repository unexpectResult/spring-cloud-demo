package com.demo.auth.service.impl;

import com.demo.auth.domain.system.Commons;
import com.demo.auth.domain.system.Token;
import com.demo.auth.domain.system.User;
import com.demo.auth.mapper.UserMapper;
import com.demo.auth.service.TokenService;
import com.demo.auth.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public Token authLogin(String username,String password) {
        User user = userMapper.login(username);
        if(user == null){
            throw new RuntimeException(Commons.USER_NOT_FOUND);
        } else if  (!user.getPassword().equals(password)){
            throw new RuntimeException(Commons.USER_PASSWORD_ERROR);
        }
        //密码置空
        user.setPassword(null);
        //获取token
        Token token = tokenUtils.createToken(user);
        return token;
    }

    @Override
    public String grantTypeCode(String buildName) {
        return null;
    }
}
