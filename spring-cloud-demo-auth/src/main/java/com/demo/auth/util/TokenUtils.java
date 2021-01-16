package com.demo.auth.util;

import com.demo.auth.domain.system.Token;
import com.demo.auth.domain.system.User;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Component
public class TokenUtils {

    private static final long DEAD_TIME = 1000*60*31;

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SaltUtils saltUtils;

    /**
     * 创建token
     * @param user 传入的用户对象
     * @return
     */
    public Token createToken(User user){
        String tokenStr = createTokenStr(user);
        String refreshToken = MD5Encoder.encode((user.getUserName()+saltUtils.getSalt(8)+DateUtils.nowTime()).substring(0, 16).getBytes());
        Token token = new Token(tokenStr,System.currentTimeMillis()+DEAD_TIME,refreshToken,user);
        System.out.println(token);
        redisUtils.storeValue(tokenStr,token, TimeUnit.MILLISECONDS,DEAD_TIME);
        //获取当前时间
        long now = System.currentTimeMillis();
        return token;
    }

    private String createTokenStr(User user) {
        return Base64.getEncoder().encodeToString(
                (user.getUserName()+saltUtils.getSalt(8) + new DateUtils().nowTime() + user.getUserPhone()).getBytes());
    }

    public Token refreshToken(String accessToken,String refreshToken){
        //获取未过期的token
        Token token = (Token) redisUtils.getValue(accessToken);
        if (token == null) return null;
        //判断refreshToken是否一致
        if(!StringUtils.isEmpty(refreshToken) && refreshToken.equals(token.getRefreshToken())){
            //重新创建token字符串
            String tokenStr = createTokenStr(token.getUser());
            //刷新token字符串
            token.setToken(tokenStr);
            //刷新过期时间
            token.setExp(System.currentTimeMillis()+DEAD_TIME);
            //重新存储
            redisUtils.storeValue(tokenStr,token,TimeUnit.MILLISECONDS,DEAD_TIME);
            //删除之前的token
            redisUtils.delByKey(accessToken);
            return token;
        }
        return null;
    }

    public boolean accessToken(String accessToken,String oldToken){
        //获取未过期的token
        Token token = (Token)redisUtils.getValue(accessToken);
        if(token != null && token.getRefreshToken().equals(oldToken)){
            return true;
        }
        return false;
    }

}
