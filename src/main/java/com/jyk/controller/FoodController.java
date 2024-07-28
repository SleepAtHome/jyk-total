package com.jyk.controller;

import com.jyk.dao.Food;
import com.jyk.service.FoodService;
import com.jyk.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 食材Controller
 * @date : Created in 2024/7/28 3:17
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/search-all")
    public ResponseVo<List<Food>> searchAllDishes(String str) {
        System.out.println("获取所有食材, 请求参数为:  " + str);
        return foodService.selectAllFoods();
    }

    @PostMapping("/search")
    public ResponseVo<List<Food>> searchDishesByName(@RequestBody Food foodName) {
        System.out.println("根据条件获取食材, 请求参数name为:  " + foodName);
        return foodService.getFoodByName(foodName.getFoodName());
    }

    @PostMapping("/add")
    public ResponseVo<Integer> addOneDish(@RequestBody Food food) {
        System.out.println("增加食材,请求参数name为:  " + food);
        return foodService.insertOneFood(food);
    }
}
