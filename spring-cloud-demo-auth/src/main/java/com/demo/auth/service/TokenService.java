package com.demo.auth.service;

import com.demo.auth.domain.system.Result;
import com.demo.auth.domain.system.Token;

public interface TokenService {

    /**
     * 获取token授权
     *
     * @param username
     * @return
     */
    Token authLogin(String username,String password);

    /**
     * 授权码模式
     *
     * @param buildName 获取平台模式
     * @return
     */
    String grantTypeCode(String buildName);

    Token refreshToken(String accessToken, String refreshToken);

}
