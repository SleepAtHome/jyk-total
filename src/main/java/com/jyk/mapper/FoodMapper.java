package com.jyk.mapper;

import com.jyk.dao.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Mapper
 * @date : Created in 2024/7/28 0:45
 */
@Mapper
public interface FoodMapper {
    List<Food> selectAllFoods();

    List<Food> selectFoodsByNameLike(@Param("name") String name);

    int insertFood(Food food);

//    int updateUser(User user);
//
//    int deleteUser(Integer id);
}
