package com.jyk.service.impl;

import com.jyk.controller.req.DishRequest;
import com.jyk.dao.Dish;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.DishMapper;
import com.jyk.service.DishService;
import com.jyk.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品Service实现类
 * @date : Created in 2024/7/28 0:26
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true) // 在一个类中调用本类的方法，让事务生效
public class DishServiceImpl implements DishService {

    @Autowired
    DishMapper dishMapper;

    @Override
    public ResponseVo<List<Dish>> selectAllDishes() {
        List<Dish> dishes = dishMapper.selectAllDishes();
        return ResponseVo.success(dishes);
    }

    @Override
    public ResponseVo<Integer> insertOneDish(DishRequest dishRequest) {
        Dish insertDish = new Dish();

        insertDish.setDishName(dishRequest.getDishName());

        String tempFood = "";
        if (!CollectionUtils.isEmpty(dishRequest.getFoodList())) {
            for (String food: dishRequest.getFoodList()) {
                if (!StringUtils.isEmpty(food)) {
                    tempFood = tempFood + food + ",";
                }
            }
            if (tempFood.endsWith(",")) {
                tempFood = tempFood.substring(0, tempFood.length() - 1);
            }
            insertDish.setFood(tempFood);
        } else {
            insertDish.setFood("");
        }

        String tempSeasoning = "";
        if (!CollectionUtils.isEmpty(dishRequest.getSeasoningList())) {
            for (String se: dishRequest.getSeasoningList()) {
                if (!StringUtils.isEmpty(se)) {
                    tempSeasoning = tempSeasoning + se + ",";
                }
            }
            if (tempSeasoning.endsWith(",")) {
                tempSeasoning = tempSeasoning.substring(0, tempSeasoning.length() - 1);
            }
            insertDish.setSeasoning(tempSeasoning);
        } else {
            insertDish.setSeasoning("");
        }

        boolean paramResult = checkParam(insertDish);

        if (!paramResult) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }

        // 如果更新人或者创建人为空，默认为景元奎
        if (StringUtils.isEmpty(insertDish.getUpdateBy()) || StringUtils.isEmpty(insertDish.getCreateBy())) {
            insertDish.setUpdateBy("景元奎");
            insertDish.setCreateBy("景元奎");
        }
        Date date = new Date();
        insertDish.setCreateTime(date);
        insertDish.setUpdateTime(date);

        int result = dishMapper.insertDish(insertDish);

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

    @Override
    public ResponseVo<Integer> uploadFiles(MultipartFile[] files, Integer dishId) {
        // 上传文件步骤
        String os = System.getProperty("os.name");
        // windows系统
        if (os.toLowerCase().startsWith("win")) {
            // 获取项目相对路径
            String projectPath = System.getProperty("user.dir");
            String imgDir = projectPath + "\\files\\pic";
            try {
                // 调用本类事务方法，不能本类直接调用，因为这样就没有经过Spring容器，事务就不会生效，需要通过Spring去调用
                DishServiceImpl currentProxy = (DishServiceImpl) AopContext.currentProxy();
                currentProxy.saveFiles(files, imgDir, dishId);
            } catch (IOException e) {
                System.out.println("上传文件异常！！");
                throw new RuntimeException(e);
            }
        }




        return ResponseVo.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveFiles(MultipartFile[] files, String dirPath, Integer dishId) throws IOException {
        // 写入数据库
        String imgNames = "";
        for (MultipartFile file: files) {
            imgNames = imgNames+file.getOriginalFilename()+",";
        }
        Dish updateDish = new Dish();
        updateDish.setId(dishId);
        updateDish.setImgDir(dirPath);
        updateDish.setImgName(imgNames);
        updateDish.setUpdateBy("JYK-uploadFiles");
        // updateTime在Mapper文件里写
        dishMapper.updateDish(updateDish);

        // 写入文件
        for (MultipartFile file: files) {
            // 确保目录存在
            File uploadDirectory = new File(dirPath);
            if (!uploadDirectory.exists()) {
                uploadDirectory.mkdir();
            }
            // 文件全路径(包括文件名)
            File finalFile = new File(dirPath + File.separator + file.getOriginalFilename());
            // 将MultipartFile写入到目标文件
            file.transferTo(finalFile);

            System.out.println("上传文件："+dirPath + File.separator + file.getOriginalFilename());
        }
    }

}
