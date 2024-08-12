package com.jyk.controller;

import com.jyk.controller.req.DishRequest;
import com.jyk.dao.Dish;
import com.jyk.schedule.JYKSpringSchedule;
import com.jyk.service.DishService;
import com.jyk.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Controller
 * @date : Created in 2024/7/27 23:48
 */
@RestController
@RequestMapping("/dish")
public class DishController {

    private static final Logger logger = LoggerFactory.getLogger(DishController.class);

    @Autowired
    DishService dishService;

    @PostMapping("/search-all")
    public ResponseVo<List<Dish>> searchAllDishes(String str) {
        logger.info("获取所有菜品, 请求参数为:  " + str);
        return dishService.selectAllDishes();
    }

    @PostMapping("/search")
    public ResponseVo<List<Dish>> searchDishesByName(@RequestBody Dish dish) {
        logger.info("根据条件获取菜品,dish:  " + dish);
        return dishService.getDishByName(dish.getDishName());
    }

    @PostMapping("/add")
    public ResponseVo<Integer> addOneDish(@RequestBody DishRequest dishRequest) {
        logger.info("根据条件获取菜品, 请求参数dishRequest为:  " + dishRequest);
        return dishService.insertOneDish(dishRequest);
    }

    @PostMapping("upload-file")
    public ResponseVo<Integer> uploadDishFiles(@RequestParam("file") MultipartFile[] files, @RequestParam("id") Integer dishId) {
        return dishService.uploadFiles(files, dishId);
    }

}
