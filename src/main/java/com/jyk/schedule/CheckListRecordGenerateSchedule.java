package com.jyk.schedule;

import com.jyk.dao.CheckListDay;
import com.jyk.dao.CheckListRecord;
import com.jyk.dao.User;
import com.jyk.mapper.CheckListDayMapper;
import com.jyk.mapper.CheckListRecordMapper;
import com.jyk.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 每日清单定时生成
 * @date : Created in 2024/8/17 13:48
 */
@Component
public class CheckListRecordGenerateSchedule {
    private static final Logger logger = LoggerFactory.getLogger(CheckListRecordGenerateSchedule.class);

    @Autowired
    CheckListRecordMapper checkListRecordMapper;

    @Autowired
    CheckListDayMapper checkListDayMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * @Scheduled 注解可以被应用于任何方法上，并且该方法将按照配置的时间间隔自动执行。下面是一些主要的属性：
     * fixedRate: 以固定的速率执行任务，单位是毫秒。从上一次任务开始执行的时间算起。
     * fixedDelay: 以固定的延迟执行任务，单位是毫秒。从上一次任务结束的时间算起。
     * initialDelay: 在第一次执行任务前等待的时间，单位是毫秒。
     * cron: 使用 Cron 表达式来定义执行的时间表。
     *
     * 一小时执行一次
     */
    //@Scheduled(cron = "0 */30 * * * ?")
    @Scheduled(fixedDelay = 1000*60*60)
    public void generate () {
        logger.info("开始生成每日清单任务， 开始时间：{}", System.currentTimeMillis());

        // 1. 获取所有用户：
        List<User> userList = userMapper.selectAllUser();
        if (CollectionUtils.isEmpty(userList)) {
            logger.warn("未获取到任何用户");
            return;
        }

        // 2. 查找单个用户每日清单
        for (User user: userList) {
            logger.info("开始生成每日清单任务， 用户：{}", user.getName());

            List<CheckListDay> checkListDayList = checkListDayMapper.selectMappersByCondition(new CheckListDay(user.getId()));
            if (CollectionUtils.isEmpty(checkListDayList)) {
                logger.warn("未获取到任何用户每日清单");
                continue;
            }

            // 3. 单个用户的单个事件：校验并插入每日清单记录
            for (CheckListDay checkListDay: checkListDayList) {
                List<CheckListRecord> existList = checkListRecordMapper.selectTodayMappersByCondition(new CheckListRecord(checkListDay.getUserId(), checkListDay.getId()));
                // 如果用户当日有记录，则先校验
                // generateCount 当天已生成的次数
                int generateCount = 0;
                if (!CollectionUtils.isEmpty(existList)) {
                    generateCount = existList.size();
                    if (generateCount >= checkListDay.getFrequency()) {
                        logger.warn("用户：{}， 每日事项：{}， 当天已经生成了{}次， 不需要再生成", user.getName(), checkListDay.getMatter(), generateCount);
                        continue;
                    }
                }

                // 创建对应频率的每日清单记录(要减掉已生成的记录)
                for (int i = 0; i < checkListDay.getFrequency() - generateCount; i++) {
                    CheckListRecord checkListRecord = generateCheckListRecord(checkListDay);
                    int result = checkListRecordMapper.insertOneMapperRecordCondition(checkListRecord);
                    if (result == 1 ) {
                        logger.info("生成每日清单任务成功， 用户：{}， 每日清单：{}", user.getName(), checkListDay.getMatter());
                    } else {
                        logger.warn("生成每日清单任务失败， 用户：{}， 每日清单：{}", user.getName(), checkListDay.getMatter());
                    }
                }
            }
        }

    }

    private CheckListRecord generateCheckListRecord(CheckListDay checkListDay) {
        Date nowTime = new Date();
        CheckListRecord checkListRecord = new CheckListRecord();
        checkListRecord.setUserId(checkListDay.getUserId());
        checkListRecord.setMatterId(checkListDay.getId());
        checkListRecord.setCheckListType(1); // 1: 每日清单
        checkListRecord.setMatterStartTime(nowTime);
        // checkListRecord.setMatterFinishTime(nowTime); 刚开始创建 还没有完成时间
        checkListRecord.setFinished(0); // 0: 未完成
        checkListRecord.setProgress(0); // 0: 0%
        checkListRecord.setMemo("auto created");
        checkListRecord.setWeight(9);
        checkListRecord.setCreateBy("auto created");
        checkListRecord.setUpdateBy("auto created");
        return checkListRecord;
    }
}
