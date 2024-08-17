package com.jyk.dao;

import com.google.gson.Gson;

import java.util.Date;

/**
 * @author : Jing Yuankui
 * @description : 事项记录
 * @date : Created in 2024/8/15 23:26
 */
public class CheckListRecord {
    // 唯一标识符
    private Integer id;
    // 用户ID，表示与该事项相关的用户
    private Integer userId;
    // 事项ID，表示该记录对应的事项
    private Integer matterId;
    // 清单类型，对应清单表后缀 1-day 2-week 3-month 4-year
    private Integer checkListType;
    // 事项开始时间
    private Date matterStartTime;
    // 事项结束时间
    private Date matterFinishTime;
    // 事项是否完成的标志，1表示已完成，0表示未完成
    private Integer finished;
    // 事项的进度，通常以百分比表示
    private Integer progress;
    // 备注信息，可以用于记录额外的信息
    private String memo;
    // 权重，用于表示事项的重要性或优先级
    private Integer weight;
    // 创建该记录的用户
    private String createBy;
    // 创建时间
    private Date createTime;
    // 更新该记录的用户
    private String updateBy;
    // 更新时间
    private Date updateTime;

    public CheckListRecord() {
    }

    public CheckListRecord(Integer id, Integer userId, Integer matterId, Integer checkListType, Date matterStartTime, Date matterFinishTime, Integer finished, Integer progress, String memo, Integer weight, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.matterId = matterId;
        this.checkListType = checkListType;
        this.matterStartTime = matterStartTime;
        this.matterFinishTime = matterFinishTime;
        this.finished = finished;
        this.progress = progress;
        this.memo = memo;
        this.weight = weight;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public CheckListRecord(Integer userId, Integer matterId) {
        this.userId = userId;
        this.matterId = matterId;
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

    public Integer getMatterId() {
        return matterId;
    }

    public void setMatterId(Integer matterId) {
        this.matterId = matterId;
    }

    public Integer getCheckListType() {
        return checkListType;
    }

    public void setCheckListType(Integer checkListType) {
        this.checkListType = checkListType;
    }

    public Date getMatterStartTime() {
        return matterStartTime;
    }

    public void setMatterStartTime(Date matterStartTime) {
        this.matterStartTime = matterStartTime;
    }

    public Date getMatterFinishTime() {
        return matterFinishTime;
    }

    public void setMatterFinishTime(Date matterFinishTime) {
        this.matterFinishTime = matterFinishTime;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
