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
}
