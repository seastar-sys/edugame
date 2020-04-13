package com.dimple.common.utils;

import com.alibaba.fastjson.JSON;
import com.dimple.project.robot.robot.domain.RequestBody;
import com.dimple.project.robot.robot.domain.RequestData;
import com.dimple.project.robot.robot.domain.RequestHeader;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AndroidHttpUtil {
    public static String getbyte() {
        RequestData localRequestData = new RequestData();
        RequestBody localRequestBody = new RequestBody();
        RequestHeader localRequestHeader = new RequestHeader();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(new Date().getTime());
        localStringBuilder.append("");
        localRequestBody.setSid(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append("20191104");
        localRequestHeader.setApiLevel(localStringBuilder.toString());
        localRequestHeader.setEditionId("2.7.9");
        localRequestHeader.setEncode("UTF-8");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(new Date().getTime());
        localRequestHeader.setTime(localStringBuilder.toString());
        localRequestHeader.setDeviceToken("XiaoMi M6");
        localRequestHeader.setPlatformId("351");
        localRequestData.setHeader(localRequestHeader);
        localRequestData.setBody(localRequestBody);
        return JSON.toJSONString(localRequestData);
    }

    public static String postbyte(Map<String, Object> map){
        RequestData localRequestData = new RequestData();
        RequestBody localRequestBody = new RequestBody();
        RequestHeader localRequestHeader = new RequestHeader();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(new Date().getTime());
        localStringBuilder.append("");
        localRequestBody.setSid(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append("20191104");
        localRequestHeader.setApiLevel(localStringBuilder.toString());
        localRequestHeader.setEditionId("2.7.9");
        localRequestHeader.setEncode("UTF-8");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(new Date().getTime());
        localRequestHeader.setTime(localStringBuilder.toString());
        localRequestHeader.setPlatformId("351");
        localRequestHeader.setDeviceToken("XiaoMi M6");
        localRequestHeader.setUserId(278159781);
        localRequestHeader.setUserName("安琪");
        localRequestBody.setData(map);
        localRequestData.setHeader(localRequestHeader);
        localRequestData.setBody(localRequestBody);
        return JSON.toJSONString(localRequestData);
    }
}
