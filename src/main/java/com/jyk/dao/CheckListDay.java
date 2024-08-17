package com.jyk.dao;

import com.google.gson.Gson;

import java.util.Date;

/**
 * @author : Jing Yuankui
 * @description : 每日事项清单
 * @date : Created in 2024/8/14 23:04
 */
public class CheckListDay {

    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 事项
     */
    private String matter;
    /**
     * 频率
     */
    private Integer frequency;
    /**
     * 是否完成 完成-1 未完成-0
     */
    private Integer finished;
    /**
     * 完成进度 0-100 100为完成
     */
    private Integer progress;

    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    public CheckListDay() {
    }

    public CheckListDay(Integer id, Integer userId, String matter, Integer frequency, Integer finished, Integer progress, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.matter = matter;
        this.frequency = frequency;
        this.finished = finished;
        this.progress = progress;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public CheckListDay(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
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
