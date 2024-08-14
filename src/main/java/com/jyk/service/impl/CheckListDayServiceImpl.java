package com.jyk.service.impl;

import com.jyk.dao.CheckListDay;
import com.jyk.mapper.CheckListDayMapper;
import com.jyk.service.CheckListDayService;
import com.jyk.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 每日清单Service实现类
 * @date : Created in 2024/8/14 23:48
 */
@Service
public class CheckListDayServiceImpl implements CheckListDayService {

    @Autowired
    CheckListDayMapper checkListDayMapper;

    @Override
    public ResponseVo<List<CheckListDay>> selectAllCheckListDay() {
        return ResponseVo.success(checkListDayMapper.selectAllMappers());
    }

    @Override
    public ResponseVo<Integer> insertOneCheckListDay(CheckListDay checkListDay) {
        return ResponseVo.success(checkListDayMapper.insertOneMapper(checkListDay));
    }

    @Override
    public ResponseVo<List<CheckListDay>> getCheckListByCondition(CheckListDay checkListDay) {
        return ResponseVo.success(checkListDayMapper.selectMappersByCondition(checkListDay));
    }
}
