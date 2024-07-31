package com.jyk.controller;

import com.jyk.controller.req.DishRequest;
import com.jyk.dao.Dish;
import com.jyk.service.DishService;
import com.jyk.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Controller
 * @date : Created in 2024/7/27 23:48
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishService dishService;

    @PostMapping("/search-all")
    public ResponseVo<List<Dish>> searchAllDishes(String str) {
        System.out.println("获取所有菜品, 请求参数为:  " + str);
        return dishService.selectAllDishes();
    }

    @PostMapping("/search")
    public ResponseVo<List<Dish>> searchDishesByName(@RequestBody Dish dish) {
        System.out.println("根据条件获取菜品,dish:  " + dish);
        return dishService.getDishByName(dish.getDishName());
    }

    @PostMapping("/add")
    public ResponseVo<Integer> addOneDish(@RequestBody DishRequest dishRequest) {
        System.out.println("根据条件获取菜品, 请求参数dishRequest为:  " + dishRequest);
        return dishService.insertOneDish(dishRequest);
    }

}
