package com.demo.auth.service.impl;

import com.demo.auth.domain.system.Commons;
import com.demo.auth.domain.system.Token;
import com.demo.auth.domain.system.User;
import com.demo.auth.mapper.UserMapper;
import com.demo.auth.service.TokenService;
import com.demo.auth.util.TokenUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        String md5HashPassword = new Md5Hash(password,user.getSalt(), 1024).toString();
        if(user == null){
            throw new RuntimeException(Commons.USER_NOT_FOUND);
        } else if  (!user.getUserPassword().equals(md5HashPassword)){
            throw new RuntimeException(Commons.USER_PASSWORD_ERROR);
        }
        //密码置空
        user.setUserPassword(null);
        //获取token
        Token token = tokenUtils.createToken(user);
        return token;
    }

    @Override
    public String grantTypeCode(String buildName) {
        return null;
    }

    @Override
    public Token refreshToken(String accessToken, String refreshToken) {
        return tokenUtils.refreshToken(accessToken,refreshToken);
    }
}
