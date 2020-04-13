package com.dimple.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.dimple.project.robot.robot.domain.RobotUser;
import okhttp3.OkHttpClient;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class XianLaiUils {

    /***
     * 获取闲来登录token
     * @param user
     * @return
     */
    public static String getToken(RobotUser user){
        String loginurl = "https://bp124361qg2c8gw.xianlaigame.com/api/auth/login";
        JSONObject json = new JSONObject();
        json.put("username",user.getHhnumber());
        json.put("password",user.getHhpassword());
        json.put("areaCode","+86");
        String params = json.toString();
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),params);
        Request request = new Request.Builder()
                .addHeader("osType","2")
                .addHeader("editionid","2.1.0")
                .url(loginurl)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            JSONObject data = JSONObject.parseObject(response.body().string());
            if(!data.toString().contains("token")){
                System.out.println("登录失败！");
                return null;
            }else{
                System.out.println(data.getString("token"));
                return data.getString("token");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 查询机器人绑定战绩指定时间数据
     * @param user
     * @param beginDate 2019-08-06 11:22:32
     * @param endDate 2019-08-06 11:22:32
     * @return
     */
    public static String getAllRecord(RobotUser user,String beginDate,String endDate){
        String loginurl = "https://bp124361qg2c8gw.xianlaigame.com/api/agent/club/teamLog/allRecord";
        HashMap<String, Object> json = new HashMap<>();
        json.put("teamId", user.getHhgroup());
        json.put("beginDate", DateUtils.timeToStamp(beginDate));
        json.put("endDate", DateUtils.timeToStamp(endDate));
        json.put("userId", 0);
        json.put("start", 0);
        json.put("limit", 5);
        json.put("queryTime", new Date().getTime());
        json.put("partnerId", 0);
        byte[] bytes = AndroidHttpUtil.postbyte(json).getBytes();
        String params = json.toString();
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"),bytes);//{"header":{"encode":"0"},"result":{"code":"401","message":"??????????!","sid":"1574675841673","timestamp":1574675841673}}
        Request request = new Request.Builder()
                .addHeader("Authorization","Bearer "+user.getToken())
                .url(loginurl)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String res = response.body().string();
            System.out.println(res);
            if(!res.contains("\"code\":\"200\"")){
                return null;
            }else{
                return res;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
