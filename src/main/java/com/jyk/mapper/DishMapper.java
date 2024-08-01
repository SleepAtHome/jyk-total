package com.jyk.mapper;

import com.jyk.dao.Dish;
import com.jyk.dao.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Mapper
 * @date : Created in 2024/7/28 0:45
 */
@Mapper
public interface DishMapper {
    List<Dish> selectAllDishes();

    List<Dish> selectDishesByNameLike(String name);

    int insertDish(Dish dish);

    int updateDish(Dish dish);
//
//    int deleteUser(Integer id);
}
