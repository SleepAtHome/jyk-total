package com.jyk.dao;

import com.google.gson.Gson;

import java.util.Date;

/**
 * @author : Jing Yuankui
 * @description : 菜品类
 * @date : Created in 2024/7/27 19:55
 */
public class Dish {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 菜名
     */
    private String dishName;
    /**
     * 使用的食物
     */
    private String food;
    /**
     * 调料
     */
    private String seasoning;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getSeasoning() {
        return seasoning;
    }

    public void setSeasoning(String seasoning) {
        this.seasoning = seasoning;
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
