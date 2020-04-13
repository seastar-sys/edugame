package com.dimple.framework.WxPay;


/**
 * 微信支付配置文件
 * @author chenp
 *
 */

public class WeChatConfig {

    /**
     * 微信服务号APPID
     */
    public static String APPID="wxe14eae91b530c28e";//wx5311e5b71a30b840
    /**
     * 微信支付的商户号
     */
    public static String MCHID="1582726791";
    //1582726791  多学一门
    //1500114542 灵之动
    /**
     * 微信支付的API密钥
     */
    public static String APIKEY="1234567891011121314151617181920a";
    /**
     * 微信支付成功之后的回调地址【注意：当前回调地址必须是公网能够访问的地址】
     */
    public static String WECHAT_NOTIFY_URL_PC="http://wx.frp.fztool.com/api/wxNotify";
    /**
     * 微信统一下单API地址
     */
    public static String UFDODER_URL="https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * true为使用真实金额支付，false为使用测试金额支付（1分）
     */
    public static String WXPAY="0.01";

    public static String CREATE_IP=  "127.0.0.1";

    public static String currTime = PayForUtil.getCurrTime();
    public static  String strTime = currTime.substring(8, currTime.length());
    public static String strRandom = PayForUtil.buildRandom(4) + "";
    public static String NONCE_STR = strTime + strRandom;

}
