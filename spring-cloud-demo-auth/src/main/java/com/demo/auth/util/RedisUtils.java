package com.demo.auth.util;

import org.bouncycastle.crypto.digests.SkeinEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     * @param key
     */
    public void delByKey(String key){
        redisTemplate.delete(key);
    }

    /**
     * 存取key val
     *
     * @param key       关键字
     * @param target    目标
     * @param timeUnit  时间类型
     * @param time      时间
     */
    public void storeValue(String key, Object target, TimeUnit timeUnit,long time){
        redisTemplate.opsForValue().set(key,target,time,timeUnit);
    }

    /**
     * 获取value
     *
     * @param key 关键字
     * @return
     */
    public Object getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
