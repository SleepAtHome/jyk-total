package com.jyk.service.impl;

import com.jyk.dao.Dish;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.DishMapper;
import com.jyk.service.DishService;
import com.jyk.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Service实现类
 * @date : Created in 2024/7/28 0:26
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishMapper dishMapper;

    @Override
    public ResponseVo<List<Dish>> selectAllDishes() {
        List<Dish> dishes = dishMapper.selectAllDishes();
        return ResponseVo.success(dishes);
    }

    @Override
    public ResponseVo<Integer> insertOneDish(Dish dish) {
        boolean paramResult = checkParam(dish);

        if (!paramResult) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }

        // 如果更新人或者创建人为空，默认为景元奎
        if (StringUtils.isEmpty(dish.getUpdateBy()) || StringUtils.isEmpty(dish.getCreateBy())) {
            dish.setUpdateBy("景元奎");
            dish.setCreateBy("景元奎");
        }
        Date date = new Date();
        dish.setCreateTime(date);
        dish.setUpdateTime(date);

        int result = dishMapper.insertDish(dish);

        if (1 == result) {
            return ResponseVo.success(result);
        }
        return ResponseVo.error(result);
    }

    /**
     * 校验入参
     * @param dish
     * @return
     */
    private boolean checkParam(Dish dish) {
        boolean result = false;
        if (null != dish
                && !StringUtils.isEmpty(dish.getDishName())
                && !StringUtils.isEmpty(dish.getFood())
                && !StringUtils.isEmpty(dish.getSeasoning())
                && !StringUtils.isEmpty(dish.getChief())
                && null != dish.getPrice()
                && dish.getPrice() > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public ResponseVo<List<Dish>> getDishByName(String dishName) {
        List<Dish> dishes = new ArrayList<>();
        if (StringUtils.isEmpty(dishName)) {
            dishes = dishMapper.selectAllDishes();
        } else {
            dishes = dishMapper.selectDishesByNameLike(dishName);
        }
        return ResponseVo.success(dishes);
    }
}
