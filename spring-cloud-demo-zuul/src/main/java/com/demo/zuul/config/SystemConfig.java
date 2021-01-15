package com.demo.zuul.config;


import com.demo.commons.util.util.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {

    @Bean
    public RedisUtils redisUtils(){
        return new RedisUtils();
    }

}
