package com.jyk.controller;

import com.jyk.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jing Yuankui
 * @description : 测试Controller
 * @date : Created in 2024/8/20 0:02
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    RedisUtils redisUtils;

    @PostMapping("/redis-set")
    public String testRedis() {
        redisUtils.set("test1", "jyktest1");
        return redisUtils.get("test1").toString();
    }

}
