package com.jyk.service.impl;

import com.jyk.dao.Food;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.FoodMapper;
import com.jyk.service.FoodService;
import com.jyk.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Service实现类
 * @date : Created in 2024/7/28 0:26
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;


    @Override
    public ResponseVo<List<Food>> selectAllFoods() {
        List<Food> foods = foodMapper.selectAllFoods();
        return ResponseVo.success(foods);
    }

    @Override
    public ResponseVo<Integer> insertOneFood(Food food) {
        boolean paramResult = checkParam(food);

        if (!paramResult) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }

        // 如果更新人或者创建人为空，默认为景元奎
        if (StringUtils.isEmpty(food.getUpdateBy()) || StringUtils.isEmpty(food.getCreateBy())) {
            food.setUpdateBy("景元奎");
            food.setCreateBy("景元奎");
        }
        Date date = new Date();
        food.setCreateTime(date);
        food.setUpdateTime(date);

        int result = foodMapper.insertFood(food);

        if (1 == result) {
            return ResponseVo.success(result);
        }
        return ResponseVo.error(result);
    }

    @Override
    public ResponseVo<List<Food>> getFoodByName(String foodName) {
        List<Food> foods = foodMapper.selectFoodsByNameLike(foodName);
        return ResponseVo.success(foods);
    }

    /**
     * 校验入参
     * @param food
     * @return
     */
    private boolean checkParam(Food food) {
        boolean result = false;
        if (null != food
                && !StringUtils.isEmpty(food.getFoodName())
        ) {
            result = true;
        }
        return result;
    }

}
