package com.dimple.project.api.domain;

public class Login {
    /***
     * 账号
     */
    private String user;

    /***
     * 密码
     */
    private String pwd;

    private String imei;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
