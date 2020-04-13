package com.dimple.project.member.history.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EduHistory)表实体类
 *
 * @author 刘登辉
 * @since 2020-03-30 14:20:16
 */
@SuppressWarnings("serial")
public class EduHistory{
    
    private Integer id;
    //用户id
    private Integer userId;
    //章
    private Integer chapter;
    //节
    private Integer section;
    //关数
    private Integer subjectNumber;
    //花费时间 单位秒
    private Integer costTime;
    //总时间
    private Integer totalTime;
    //总题目数量
    private Integer totalItem;
    //正确数量
    private Integer rightItem;
    //更新时间
    private Date updatTime;

    // 0无效 1有效
    private Integer states;

    /***
     * 等级名称
     */
    private String name;


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

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(Integer subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public Integer getCostTime() {
        return costTime;
    }

    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer getRightItem() {
        return rightItem;
    }

    public void setRightItem(Integer rightItem) {
        this.rightItem = rightItem;
    }

    public Date getUpdatTime() {
        return updatTime;
    }

    public void setUpdatTime(Date updatTime) {
        this.updatTime = updatTime;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}