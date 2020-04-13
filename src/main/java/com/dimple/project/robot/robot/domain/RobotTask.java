package com.dimple.project.robot.robot.domain;

import com.dimple.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/***
 * 定时信息
 */
public class RobotTask{
    private int id;
    /***
     * 亲友圈id
     */
    private String groupid;
    /***
     * 桌号
     */
    private String deskid;
    /***
     * 唯一id
     */
    private String uuid;
    /***
     * 局数
     */
    private String circledesc;
    /***
     * 人数
     */
    private String people;
    /***
     * 游戏类型
     */
    private String playflag;
    /***
     * 大赢家
     */
    private String winner;
    /***
     * 失败者
     */
    private String owner;
    /***
     * 昵称
     */
    private String anick;
    /***
     * 用户id
     */
    private String auserid;
    /***
     * 分数
     */
    private String ascore;
    /***
     * 头像
     */
    private String aheadimg;
    /***
     * 昵称
     */
    private String bnick;
    /***
     * 用户id
     */
    private String buserid;
    /***
     * 分数
     */
    private String bscore;
    /***
     * 头像
     */
    private String bheadimg;
    /***
     * 昵称
     */
    private String cnick;
    /***
     * 用户id
     */
    private String cuserid;
    /***
     * 分数
     */
    private String cscore;
    /***
     * 头像
     */
    private String cheadimg;
    /***
     * 昵称
     */
    private String dnick;
    /***
     * 用户id
     */
    private String duserid;
    /***
     * 分数
     */
    private String dscore;
    /***
     * 头像
     */
    private String dheadimg;
    /**
     * 游戏时间
     */
    private String creattime;
    /***
     * 状态 0新增 1已调用 2已发送
     */
    private int state;

    /***
     * 调用次数
     */
    private int logs;
    /***
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addttime;
    /***
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uptime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getDeskid() {
        return deskid;
    }

    public void setDeskid(String deskid) {
        this.deskid = deskid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCircledesc() {
        return circledesc;
    }

    public void setCircledesc(String circledesc) {
        this.circledesc = circledesc;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPlayflag() {
        return playflag;
    }

    public void setPlayflag(String playflag) {
        this.playflag = playflag;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAnick() {
        return anick;
    }

    public void setAnick(String anick) {
        this.anick = anick;
    }

    public String getAuserid() {
        return auserid;
    }

    public void setAuserid(String auserid) {
        this.auserid = auserid;
    }

    public String getAscore() {
        return ascore;
    }

    public void setAscore(String ascore) {
        this.ascore = ascore;
    }

    public String getAheadimg() {
        return aheadimg;
    }

    public void setAheadimg(String aheadimg) {
        this.aheadimg = aheadimg;
    }

    public String getBnick() {
        return bnick;
    }

    public void setBnick(String bnick) {
        this.bnick = bnick;
    }

    public String getBuserid() {
        return buserid;
    }

    public void setBuserid(String buserid) {
        this.buserid = buserid;
    }

    public String getBscore() {
        return bscore;
    }

    public void setBscore(String bscore) {
        this.bscore = bscore;
    }

    public String getBheadimg() {
        return bheadimg;
    }

    public void setBheadimg(String bheadimg) {
        this.bheadimg = bheadimg;
    }

    public String getCnick() {
        return cnick;
    }

    public void setCnick(String cnick) {
        this.cnick = cnick;
    }

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }

    public String getCscore() {
        return cscore;
    }

    public void setCscore(String cscore) {
        this.cscore = cscore;
    }

    public String getCheadimg() {
        return cheadimg;
    }

    public void setCheadimg(String cheadimg) {
        this.cheadimg = cheadimg;
    }

    public String getDnick() {
        return dnick;
    }

    public void setDnick(String dnick) {
        this.dnick = dnick;
    }

    public String getDuserid() {
        return duserid;
    }

    public void setDuserid(String duserid) {
        this.duserid = duserid;
    }

    public String getDscore() {
        return dscore;
    }

    public void setDscore(String dscore) {
        this.dscore = dscore;
    }

    public String getDheadimg() {
        return dheadimg;
    }

    public void setDheadimg(String dheadimg) {
        this.dheadimg = dheadimg;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLogs() {
        return logs;
    }

    public void setLogs(int logs) {
        this.logs = logs;
    }

    public Date getAddttime() {
        return addttime;
    }

    public void setAddttime(Date addttime) {
        this.addttime = addttime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}
