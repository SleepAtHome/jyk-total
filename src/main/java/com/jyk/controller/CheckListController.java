package com.jyk.controller;

import com.jyk.dao.CheckListDay;
import com.jyk.service.CheckListDayService;
import com.jyk.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 检查清单
 * @date : Created in 2024/8/14 22:35
 */
@RestController
@RequestMapping("/check-list")
public class CheckListController {
    private static final Logger logger = LoggerFactory.getLogger(CheckListController.class);

    @Autowired
    CheckListDayService checkListDayService;

    @PostMapping("/search-all")
    public ResponseVo<List<CheckListDay>> searchAllCheckListDay(String str) {
        logger.info("获取所有CheckList, 请求参数为:  " + str);
        return checkListDayService.selectAllCheckListDay();
    }

    @PostMapping("/search-condition")
    public ResponseVo<List<CheckListDay>> searchCheckListDayByCondition(@RequestBody CheckListDay checkListDay) {
        logger.info("根据条件获取CheckList,checkListDay:  " + checkListDay);
        return checkListDayService.getCheckListByCondition(checkListDay);
    }

    @PostMapping("/add")
    public ResponseVo<Integer> addOneCheckListDay(@RequestBody CheckListDay checkListDay) {
        logger.info("增加一个每日事项（用户）, 请求参数checkListDay:  " + checkListDay);
        return checkListDayService.insertOneCheckListDay(checkListDay);
    }

    @PostMapping("/update")
    public ResponseVo<Integer> updateCheckListDay(@RequestBody CheckListDay checkListDay) {
        return null;
    }

}
