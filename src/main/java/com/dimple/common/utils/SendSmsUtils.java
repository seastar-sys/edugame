package com.dimple.common.utils;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;


public class SendSmsUtils {

    private static DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FkZ6xQxVuEycB6nvfru", "i7ErKscS47ZK4ZZm1jy8BPVPqP5X3N");

    public static boolean send(String phone,String temp,String param){
        //DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FkZ6xQxVuEycB6nvfru", "i7ErKscS47ZK4ZZm1jy8BPVPqP5X3N");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "多学一门");
        request.putQueryParameter("TemplateCode", temp);
        request.putQueryParameter("TemplateParam", param);
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            System.out.println(data);
            if(data.contains("OK")){
                return true;
            }
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FkZ6xQxVuEycB6nvfru", "i7ErKscS47ZK4ZZm1jy8BPVPqP5X3N");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15225687370");
        request.putQueryParameter("SignName", "多学一门");
        request.putQueryParameter("TemplateCode", "SMS_181720409");
        request.putQueryParameter("TemplateParam", "{\"code\":\"1234\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
