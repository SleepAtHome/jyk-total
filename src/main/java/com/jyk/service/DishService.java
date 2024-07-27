package com.jyk.service;

import com.jyk.dao.Dish;
import com.jyk.vo.ResponseVo;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 食物Service
 * @date : Created in 2024/7/27 23:49
 */
public interface DishService {
    ResponseVo<List<Dish>> selectAllDishes();
    ResponseVo<Integer> insertOneDish(Dish dish);
    ResponseVo<List<Dish>> getDishByName(String dishName);

    /*int updateUser(User user);
    int deleteUser(Integer id);*/
}
