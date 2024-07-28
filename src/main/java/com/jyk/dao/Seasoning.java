package com.jyk.dao;

import com.google.gson.Gson;

import java.util.Date;

/**
 * @author : Jing Yuankui
 * @description : 调料类
 * @date : Created in 2024/7/28 0:01
 */
public class Seasoning {
    /**
     * 调料ID
     */
    private Integer id;
    /**
     * 调料名称
     */
    private String seasoningName;
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

    public String getSeasoningName() {
        return seasoningName;
    }

    public void setSeasoningName(String seasoningName) {
        this.seasoningName = seasoningName;
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
