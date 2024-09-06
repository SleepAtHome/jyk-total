package com.jyk.service.impl;

import com.jyk.dao.CheckListDay;
import com.jyk.dao.User;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.CheckListDayMapper;
import com.jyk.mapper.UserMapper;
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

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseVo<List<CheckListDay>> selectAllCheckListDay() {
        return ResponseVo.success(checkListDayMapper.selectAllMappers());
    }

    @Override
    public ResponseVo<Integer> insertOneCheckListDay(CheckListDay checkListDay) {
        if (null == checkListDay || null == checkListDay.getUserId()) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }
        User dataU = userMapper.getUserById(checkListDay.getUserId());
        if (null == dataU) {
            return ResponseVo.error(ResponseEnum.USER_NOT_EXIST);
        }

        checkListDay.setCreateBy(dataU.getName());
        checkListDay.setUpdateBy(dataU.getName());

        return ResponseVo.success(checkListDayMapper.insertOneMapperSelective(checkListDay));
    }

    @Override
    public ResponseVo<List<CheckListDay>> getCheckListByCondition(CheckListDay checkListDay) {
        return ResponseVo.success(checkListDayMapper.selectMappersByCondition(checkListDay));
    }

    @Override
    public ResponseVo<Integer> updateCheckListDay(CheckListDay checkListDay) {
        if (null == checkListDay || null == checkListDay.getId()) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }
        return null;
    }

    @Override
    public ResponseVo<Integer> deleteCheckListDay(CheckListDay checkListDay) {
        int result = checkListDayMapper.deleteOneMapperById(checkListDay.getId());
        return ResponseVo.success(result);
    }
}
