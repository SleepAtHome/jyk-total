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
    /**
     * 获取所有菜品
     * @return
     */
    ResponseVo<List<Dish>> selectAllDishes();

    /**
     * 增加一个菜品
     * @param dish
     * @return
     */
    ResponseVo<Integer> insertOneDish(Dish dish);

    /**
     * 根据菜名获取菜品
     * @param dishName
     * @return
     */
    ResponseVo<List<Dish>> getDishByName(String dishName);

    /*int updateUser(User user);
    int deleteUser(Integer id);*/
}
