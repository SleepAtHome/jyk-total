package com.jyk.service.impl;

import com.jyk.dao.CheckListDay;
import com.jyk.dao.CheckListRecord;
import com.jyk.dao.User;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.CheckListDayMapper;
import com.jyk.mapper.CheckListRecordMapper;
import com.jyk.mapper.UserMapper;
import com.jyk.service.CheckListRecordService;
import com.jyk.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 事项记录
 * @date : Created in 2024/8/16 0:22
 */
@Service
public class CheckListRecordServiceImpl implements CheckListRecordService {

    private static final Logger logger = LoggerFactory.getLogger(CheckListRecordServiceImpl.class);


    @Autowired
    CheckListRecordMapper checkListRecordMapper;

    @Autowired
    CheckListDayMapper checkListDayMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVo<List<CheckListRecord>> getTodayMapper(CheckListRecord checkListRecord) {
        return ResponseVo.success(checkListRecordMapper.selectTodayMappersByCondition(checkListRecord));
    }

    @Override
    public ResponseVo<Integer> insertOneMapperRecordCondition(CheckListRecord checkListRecord) {
        logger.info("新增一个事项记录: {}", checkListRecord);
        return ResponseVo.success(checkListRecordMapper.insertOneMapperRecordCondition(checkListRecord));
    }

    @Override
    public ResponseVo<Integer> manuallyGenerated(CheckListRecord checkListRecord) {
        // 判断入参
        if (null == checkListRecord || null == checkListRecord.getUserId()) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }

        // 用户每日清单判断
        Integer userId = checkListRecord.getUserId();
        List<CheckListDay> checkListDayList = checkListDayMapper.selectMappersByCondition(new CheckListDay(userId));
        if (CollectionUtils.isEmpty(checkListDayList)) {
            logger.warn("未获取到任何用户每日清单");
            return ResponseVo.error(ResponseEnum.USER_NO_CHECKLIST_ERROR);
        }

        User currentUser = userMapper.getUserById(userId);

        int insertCount = 0;

        // 单个用户的单个事件：校验并插入每日清单记录
        for (CheckListDay checkListDay: checkListDayList) {
            List<CheckListRecord> existList = checkListRecordMapper.selectTodayMappersByCondition(new CheckListRecord(checkListDay.getUserId(), checkListDay.getId()));
            // 如果用户当日有记录，则先校验
            // generateCount 当天已生成的次数
            int generateCount = 0;
            if (!CollectionUtils.isEmpty(existList)) {
                generateCount = existList.size();
                if (generateCount >= checkListDay.getFrequency()) {
                    logger.warn("用户：{}， 每日事项：{}， 当天已经生成了{}次， 不需要再生成", currentUser.getName(), checkListDay.getMatter(), generateCount);
                    continue;
                }
            }

            // 创建对应频率的每日清单记录(要减掉已生成的记录)
            for (int i = 0; i < checkListDay.getFrequency() - generateCount; i++) {
                CheckListRecord newCheckListRecord = generateCheckListRecord(checkListDay);
                int result = checkListRecordMapper.insertOneMapperRecordCondition(newCheckListRecord);
                if (result == 1 ) {
                    logger.info("生成每日清单任务成功， 用户：{}， 每日清单：{}", currentUser.getName(), checkListDay.getMatter());
                    insertCount++;
                } else {
                    logger.warn("生成每日清单任务失败， 用户：{}， 每日清单：{}", currentUser.getName(), checkListDay.getMatter());
                }
            }
        }

        return ResponseVo.success(insertCount);
    }

    @Override
    public ResponseVo<Integer> finishOneMapperRecord(CheckListRecord checkListRecord) {
        // 入参：user_id， matter_id， finished， memo， update_by
        checkListRecord.setMatterFinishTime(new Date());
        return ResponseVo.success(checkListRecordMapper.updateOneMapper(checkListRecord));
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
