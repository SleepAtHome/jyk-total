package com.jyk.dao;

import com.google.gson.Gson;

import java.util.Date;

/**
 * @author : Jing Yuankui
 * @description : 食品类
 * @date : Created in 2024/7/27 23:58
 */
public class Food {
    /**
     * 食品ID
     */
    private Integer id;
    /**
     * 食品名称
     */
    private String foodName;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
