package com.jyk.service;

import com.jyk.dao.CheckListRecord;
import com.jyk.vo.ResponseVo;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 事项清单Service
 * @date : Created in 2024/8/14 22:36
 */
public interface CheckListRecordService {

    /**
     * 根据条件查询CheckListDay
     * @param checkListRecord
     * @return
     */
    ResponseVo<List<CheckListRecord>> getTodayMapper(CheckListRecord checkListRecord);

    ResponseVo<Integer> insertOneMapperRecordCondition(CheckListRecord checkListRecord);

    /**
     * 手动生成当天未生成的事项记录（根据最新的配置生成），入参为用户ID
     * @param checkListRecord
     * @return
     */
    ResponseVo<Integer> manuallyGenerated(CheckListRecord checkListRecord);

    /**
     * 完成事项
     * @param checkListRecord
     * @return
     */
    ResponseVo<Integer> finishOneMapperRecord(CheckListRecord checkListRecord);
}
