package com.jyk.service;

import com.jyk.dao.Food;
import com.jyk.vo.ResponseVo;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 食材Service
 * @date : Created in 2024/7/28 3:18
 */
public interface FoodService {
    ResponseVo<List<Food>> selectAllFoods();
    ResponseVo<Integer> insertOneFood(Food food);
    ResponseVo<List<Food>> getFoodByName(String foodName);
}
