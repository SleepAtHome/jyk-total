package com.jyk.service;

import com.jyk.dao.CheckListDay;
import com.jyk.vo.ResponseVo;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 事项清单Service
 * @date : Created in 2024/8/14 22:36
 */
public interface CheckListDayService {
    /**
     * 获取所有事项
     * @return
     */
    ResponseVo<List<CheckListDay>> selectAllCheckListDay();

    /**
     * 增加一个每日事项
     * @param checkListDay
     * @return
     */
    ResponseVo<Integer> insertOneCheckListDay(CheckListDay checkListDay);

    /**
     * 根据条件查询CheckListDay
     * @param checkListDay
     * @return
     */
    ResponseVo<List<CheckListDay>> getCheckListByCondition(CheckListDay checkListDay);

    /**
     * 更新CheckListDay
     * @param checkListDay
     * @return
     */
    ResponseVo<Integer> updateCheckListDay(CheckListDay checkListDay);

    /**
     * 删除CheckListDay
     * @param checkListDay
     * @return
     */
    ResponseVo<Integer> deleteCheckListDay(CheckListDay checkListDay);
}
