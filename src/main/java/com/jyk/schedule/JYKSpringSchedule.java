package com.jyk.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : Jing Yuankui
 * @description : Spring的定时任务
 * @date : Created in 2024/7/31 1:20
 */
@Component
public class JYKSpringSchedule {

    private static final Logger logger = LoggerFactory.getLogger(JYKSpringSchedule.class);

    // 每隔1小时执行一次
    @Scheduled(fixedRate = 1000*60*60)
    public void reportCurrentTime() {

        logger.info("现在时间：{}", System.currentTimeMillis());

    }
}
