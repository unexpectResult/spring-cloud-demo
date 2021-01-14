package com.demo.auth.util;

import com.demo.auth.domain.system.Commons;
import com.demo.auth.domain.system.Token;
import com.demo.auth.domain.system.User;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.concurrent.TimeUnit;
import com.demo.auth.util.DateUtils;

@Component
public class TokenUtils {

    private static final long DEAD_TIME = 1000*60*31;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 创建token
     * @param user 传入的用户对象
     * @return
     */
    public Token createToken(User user){
        String tokenStr = createTokenStr(user);
        String refreshToken = MD5Encoder.encode((user.getUserName()+"@"+new DateUtils().nowTime()+"#").getBytes());
        Token token = new Token(tokenStr,System.currentTimeMillis()+DEAD_TIME,refreshToken,user);
        redisUtils.storeValue(tokenStr,token, TimeUnit.MILLISECONDS,DEAD_TIME);
        //获取当前时间
        long now = System.currentTimeMillis();
        return token;
    }

    private String createTokenStr(User user) {
        return new String(Base64.getEncoder().encodeToString(
                (user.getUserName()+"@"+new DateUtils().nowTime() +"#"+ Commons.SECRET.getBytes()).getBytes())
        );
    }

    public Token refreshToken(String accessToken,String refreshToken){
        //获取未过期的token
        Token token = (Token) redisUtils.getValue(accessToken);
        //判断refreshToken是否一致
        if(!StringUtils.isEmpty(refreshToken)&&refreshToken.equals(token.getRefreshToken())){
            //重新获取token字符串
            String tokenStr =createToken(token.getUser());
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
    }

    public boolean accessToken(String accessToken,String role){
        Token token = (Token)redisUtils.getValue(accessToken);
        if(token != null && token.getUser().getRole().equals(role)){
            return true;
        }
        return false;
    }

}
