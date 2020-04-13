package com.dimple.project.member.user.entity;

import java.util.*;
import java.io.Serializable;

/**
 * (EduUser)表实体类
 *
 * @author 刘登辉
 * @since 2020-03-10 17:57:11
 */
@SuppressWarnings("serial")
public class EduUser{
    
    private Integer id;
    //手机号
    private String phnumber;
    //密码
    private String pass;
    //昵称
    private String nick;
    //openid 微信openid
    private String openid;
    //头像
    private String grade;
    //token
    private String token;
    //状态 0正常 1禁用
    private Integer state;
    //0 默认用户 1 半年 1 一年
    private Integer levels;
    //到期时间
    private Date endTime;
    //备注
    private String remark;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    public Map<String,Object> getMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("phnumber",phnumber);
        map.put("pass",pass);
        map.put("nick",nick);
        map.put("openid",openid);
        map.put("grade",grade);
        map.put("token",token);
        map.put("state",state);
        map.put("levels",levels);
        map.put("endTime",endTime);
        map.put("remark",remark);
        map.put("createTime",createTime);
        map.put("updateTime",updateTime);
        return map;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    }