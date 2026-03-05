package com.health.notification.controller;

import com.health.notification.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        redisTestService.saveMessage(key, value);
        return "Saved to Redis!";
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        return redisTestService.getMessage(key);
    }
}
