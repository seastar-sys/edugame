package com.dimple.project.member.order.entity;

import java.io.Serializable;

/**
 * (EduOrder)表实体类
 *
 * @author 刘登辉
 * @since 2020-03-10 22:36:38
 */
@SuppressWarnings("serial")
public class EduOrder{
    
    private Integer id;
    //用户id
    private Integer userId;
    //用户手机号
    private String phnumber;
    //用户昵称
    private String nick;
    //商户订单号
    private String nonceStr;
    //金额
    private Integer totalFee;
    //商品描述
    private String body;
    
    private String sign;
    
    private Integer state;


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

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    }