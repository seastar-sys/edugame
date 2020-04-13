package com.dimple.project.member.punch.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EduPunch)表实体类
 *
 * @author 刘登辉
 * @since 2020-03-30 18:03:33
 */
@SuppressWarnings("serial")
public class EduPunch{
    
    private Integer id;
    //打卡用户
    private Integer userId;
    //打卡时间
    private Date updatetime;


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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    }