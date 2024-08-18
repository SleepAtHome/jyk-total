package com.jyk.controller;

import com.jyk.dao.CheckListRecord;
import com.jyk.service.CheckListRecordService;
import com.jyk.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 事项记录Controller
 * @date : Created in 2024/8/16 0:26
 */
@RestController
@RequestMapping("/check-list-record")
public class CheckListRecordController {
    private static final Logger logger = LoggerFactory.getLogger(CheckListController.class);

    @Autowired
    CheckListRecordService checkListRecordService;

    @PostMapping("/search-today-condition")
    public ResponseVo<List<CheckListRecord>> searchTodayMapperByCondition(@RequestBody CheckListRecord checkListRecord) {
        logger.info("获取今日事项, 查询条件: {} ", checkListRecord);
        return checkListRecordService.getTodayMapper(checkListRecord);
    }

    @PostMapping("/add")
    public ResponseVo<Integer> addOneMapperRecordCondition(@RequestBody CheckListRecord checkListRecord) {
        logger.info("增加今日事项, 入参: {} ", checkListRecord);
        return checkListRecordService.insertOneMapperRecordCondition(checkListRecord);
    }

    /**
     * 手动生成当天未生成的事项记录（根据最新的配置生成），入参为用户ID
     * @param checkListRecord
     * @return
     */
    @PostMapping("/manually-generated")
    public ResponseVo<Integer> manuallyGenerated(@RequestBody CheckListRecord checkListRecord) {
        logger.info("手动生成今日事项, 入参: {} ", checkListRecord);
        return checkListRecordService.insertOneMapperRecordCondition(checkListRecord);
    }
}
