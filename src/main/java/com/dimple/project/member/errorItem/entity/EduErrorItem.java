package com.dimple.project.member.errorItem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EduErrorItem)表实体类
 *
 * @author 刘登辉
 * @since 2020-04-04 00:44:16
 */
@SuppressWarnings("serial")
public class EduErrorItem{
    
    private Integer id;
    //用户id
    private Integer userId;
    //错题id
    private Integer itemBankId;
    //章
    private Integer chapter;
    //节
    private Integer section;
    //关数
    private Integer subjectNumber;
    //添加时间
    private Date uptime;


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

    public Integer getItemBankId() {
        return itemBankId;
    }

    public void setItemBankId(Integer itemBankId) {
        this.itemBankId = itemBankId;
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

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    }