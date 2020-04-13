package com.dimple.project.member.speed.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EduSpeed)表实体类
 *
 * @author 刘登辉
 * @since 2020-03-04 18:48:26
 */
@SuppressWarnings("serial")
public class EduSpeed{
    
    private Integer id;
    //用户id
    private Integer userId;
    //章
    private Integer chapter;
    //节
    private Integer section;
    //关数
    private Integer subjectNumber;
    //更新时间
    private Date updatTime;


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

    public Date getUpdatTime() {
        return updatTime;
    }

    public void setUpdatTime(Date updatTime) {
        this.updatTime = updatTime;
    }

    }