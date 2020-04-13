package com.dimple.project.member.member.domain;

import com.dimple.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/***
 * 机器人信息
 */
public class MemberUser extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private int id;
    /***
     * 账号
     */
    private String number;
    /***
     * 密码
     */
    private String password;
    /***
     * 机人名字
     */
    private String rname;
    /***
     * 调用接口用的token
     */
    private String token;
    /***
     * 绑定手机IMEI
     */
    private String imei;
    /***
     * 闲聊账号
     */
    private String xlnumber;
    /***
     * 闲聊密码
     */
    private String xlpassword;
    /****
     * 闲聊群
     */
    private String xlgroup;
    /***
     * mqtt账号
     */
    private String mquser;
    /***
     * mqtt密码
     */
    private String mqpwd;
    /***
     * mqtt 订阅频道 public
     */
    private String mqpublic;
    /***
     * Mqtt 发送频道
     */
    private String mqsend;
    /****
     * 状态 0未使用 1使用中
     */
    private String state;
    /***
     * 闲来账号是否正常 0 正常 1不正常
     */
    private int online;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /***
     * 合伙人账号
     */
    private String hhnumber;
    /***
     * 合伙人密码
     */
    private String hhpassword;
    /***
     * 合伙人亲友圈id
     */
    private String hhgroup;
    /***
     * 备注
     */
    private String remark;

    /***
     * 失败后登录次数
     */
    private int login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getXlnumber() {
        return xlnumber;
    }

    public void setXlnumber(String xlnumber) {
        this.xlnumber = xlnumber;
    }

    public String getXlpassword() {
        return xlpassword;
    }

    public void setXlpassword(String xlpassword) {
        this.xlpassword = xlpassword;
    }

    public String getXlgroup() {
        return xlgroup;
    }

    public void setXlgroup(String xlgroup) {
        this.xlgroup = xlgroup;
    }

    public String getMquser() {
        return mquser;
    }

    public void setMquser(String mquser) {
        this.mquser = mquser;
    }

    public String getMqpwd() {
        return mqpwd;
    }

    public void setMqpwd(String mqpwd) {
        this.mqpwd = mqpwd;
    }

    public String getMqpublic() {
        return mqpublic;
    }

    public void setMqpublic(String mqpublic) {
        this.mqpublic = mqpublic;
    }

    public String getMqsend() {
        return mqsend;
    }

    public void setMqsend(String mqsend) {
        this.mqsend = mqsend;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
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

    public String getHhnumber() {
        return hhnumber;
    }

    public void setHhnumber(String hhnumber) {
        this.hhnumber = hhnumber;
    }

    public String getHhpassword() {
        return hhpassword;
    }

    public void setHhpassword(String hhpassword) {
        this.hhpassword = hhpassword;
    }

    public String getHhgroup() {
        return hhgroup;
    }

    public void setHhgroup(String hhgroup) {
        this.hhgroup = hhgroup;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
}
