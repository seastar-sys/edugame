package com.dimple.project.api.domain;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.google.gson.JsonObject;

public class Info {
    /***
     * 接口类型
     * 0 注册
     * 1 发送
     * 2 关闭
     */
    private int type;
    /***
     * 订阅频道
     */
    private String topic;

    /***
     * 发送数据
     */
    private String data;

    /***
     * token
     */
    private String token;
    /***
     * 标题
     */
    private String title;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    //@JsonSerialize(using = CustomDateSerializer.class)
    public String getData() {
        return data;
    }
    //@JsonDeserialize(using = DateJsonDeserializer.class)
    public void setData(String data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
