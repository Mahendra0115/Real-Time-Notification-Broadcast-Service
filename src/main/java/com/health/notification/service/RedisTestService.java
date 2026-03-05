package com.health.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTestService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveMessage(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
