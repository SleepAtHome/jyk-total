package com.jyk.controller.req;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 菜品请求类
 * @date : Created in 2024/8/1 0:31
 */
public class DishRequest {
    /**
     * 菜名
     */
    private String dishName;
    /**
     * 使用的食物-List
     */
    private List<String> foodList;
    /**
     * 调料-List
     */
    private List<String> seasoningList;
    /**
     * 主厨
     */
    private String chief;
    /**
     * 价格
     */
    private Integer price;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public List<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<String> foodList) {
        this.foodList = foodList;
    }

    public List<String> getSeasoningList() {
        return seasoningList;
    }

    public void setSeasoningList(List<String> seasoningList) {
        this.seasoningList = seasoningList;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
}
