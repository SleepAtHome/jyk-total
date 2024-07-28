package com.jyk.controller;

import com.jyk.dao.Food;
import com.jyk.dao.Seasoning;
import com.jyk.service.FoodService;
import com.jyk.service.SeasoningService;
import com.jyk.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 调料Controller
 * @date : Created in 2024/7/28 14:00
 */
@RestController
@RequestMapping("/seasoning")
public class SeasoningController {
    @Autowired
    SeasoningService seasoningService;

    @PostMapping("/search-all")
    public ResponseVo<List<Seasoning>> searchAllSeasoning(String str) {
        System.out.println("获取所有食材, 请求参数为:  " + str);
        return seasoningService.selectAllSeasoning();
    }

    @PostMapping("/search")
    public ResponseVo<List<Seasoning>> searchSeasoningByName(@RequestBody Seasoning seasoning) {
        System.out.println("根据条件获取食材, 请求参数name为:  " + seasoning.getSeasoningName());
        return seasoningService.getSeasoningByName(seasoning.getSeasoningName());
    }

    @PostMapping("/add")
    public ResponseVo<Integer> addOneSeasoning(@RequestBody Seasoning seasoning) {
        System.out.println("增加食材,请求参数name为:  " + seasoning);
        return seasoningService.insertOneSeasoning(seasoning);
    }
}
