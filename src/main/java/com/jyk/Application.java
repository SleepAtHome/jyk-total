package com.jyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : Jing Yuankui
 * @description : SpringBoot启动类
 * @date : Created in 2021/10/1 16:45
 */
@SpringBootApplication
@EnableScheduling  // 允许启动定时任务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
