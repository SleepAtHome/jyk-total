package com.jyk.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : Jing Yuankui
 * @description : Spring的定时任务
 * @date : Created in 2024/7/31 1:20
 */
@Component
public class JYKSpringSchedule {

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + System.currentTimeMillis());
    }
}
