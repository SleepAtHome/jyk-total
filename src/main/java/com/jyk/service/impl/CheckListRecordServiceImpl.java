package com.jyk.service.impl;

import com.jyk.dao.CheckListRecord;
import com.jyk.mapper.CheckListRecordMapper;
import com.jyk.service.CheckListRecordService;
import com.jyk.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 事项记录
 * @date : Created in 2024/8/16 0:22
 */
@Service
public class CheckListRecordServiceImpl implements CheckListRecordService {

    @Autowired
    CheckListRecordMapper checkListRecordMapper;

    @Override
    public ResponseVo<List<CheckListRecord>> getTodayMapper(CheckListRecord checkListRecord) {
        return ResponseVo.success(checkListRecordMapper.selectTodayMappersByCondition(checkListRecord));
    }
}
