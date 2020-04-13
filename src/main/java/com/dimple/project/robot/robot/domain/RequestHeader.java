package com.dimple.project.robot.robot.domain;

public class RequestHeader {
    private String apiLevel;
    private String corporationId;
    private String deviceToken;
    private String editionId;
    private String encode;
    private String from;
    private String imei;
    private String imsi;
    private String locale;
    private String mac;
    private String model;
    private String operator;
    private String platformId;
    private String sso_tk;
    private String subCoopId;
    private String time;
    private String timeCost;
    private String udid;
    private int userId;
    private String userName;

    public String getApiLevel()
    {
        return this.apiLevel;
    }

    public String getCorporationId()
    {
        return this.corporationId;
    }

    public String getDeviceToken()
    {
        return this.deviceToken;
    }

    public String getEditionId()
    {
        return this.editionId;
    }

    public String getEncode()
    {
        return this.encode;
    }

    public String getFrom()
    {
        return this.from;
    }

    public String getImei()
    {
        return this.imei;
    }

    public String getImsi()
    {
        return this.imsi;
    }

    public String getLocale()
    {
        return this.locale;
    }

    public String getMac()
    {
        return this.mac;
    }

    public String getModel()
    {
        return this.model;
    }

    public String getOperator()
    {
        return this.operator;
    }

    public String getPlatformId()
    {
        return this.platformId;
    }

    public String getSso_tk()
    {
        return this.sso_tk;
    }

    public String getSubCoopId()
    {
        return this.subCoopId;
    }

    public String getTime()
    {
        return this.time;
    }

    public String getTimeCost()
    {
        return this.timeCost;
    }

    public String getUdid()
    {
        return this.udid;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setApiLevel(String paramString)
    {
        this.apiLevel = paramString;
    }

    public void setCorporationId(String paramString)
    {
        this.corporationId = paramString;
    }

    public void setDeviceToken(String paramString)
    {
        this.deviceToken = paramString;
    }

    public void setEditionId(String paramString)
    {
        this.editionId = paramString;
    }

    public void setEncode(String paramString)
    {
        this.encode = paramString;
    }

    public void setFrom(String paramString)
    {
        this.from = paramString;
    }

    public void setImei(String paramString)
    {
        this.imei = paramString;
    }

    public void setImsi(String paramString)
    {
        this.imsi = paramString;
    }

    public void setLocale(String paramString)
    {
        this.locale = paramString;
    }

    public void setMac(String paramString)
    {
        this.mac = paramString;
    }

    public void setModel(String paramString)
    {
        this.model = paramString;
    }

    public void setOperator(String paramString)
    {
        this.operator = paramString;
    }

    public void setPlatformId(String paramString)
    {
        this.platformId = paramString;
    }

    public void setSso_tk(String paramString)
    {
        this.sso_tk = paramString;
    }

    public void setSubCoopId(String paramString)
    {
        this.subCoopId = paramString;
    }

    public void setTime(String paramString)
    {
        this.time = paramString;
    }

    public void setTimeCost(String paramString)
    {
        this.timeCost = paramString;
    }

    public void setUdid(String paramString)
    {
        this.udid = paramString;
    }

    public void setUserId(int paramInt)
    {
        this.userId = paramInt;
    }

    public void setUserName(String paramString)
    {
        this.userName = paramString;
    }

    public String toString()
    {
        StringBuilder localStringBuilder1 = new StringBuilder();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[apiLevel:");
        ((StringBuilder)localObject).append(getApiLevel());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[imei:");
        ((StringBuilder)localObject).append(getImei());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[imsi:");
        ((StringBuilder)localObject).append(getImsi());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[deviceToken:");
        ((StringBuilder)localObject).append(getDeviceToken());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[corporationId:");
        ((StringBuilder)localObject).append(getCorporationId());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[editionId:");
        ((StringBuilder)localObject).append(getEditionId());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[encode:");
        ((StringBuilder)localObject).append(getEncode());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[locale:");
        ((StringBuilder)localObject).append(getLocale());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = getModel().replaceAll(" ", "");
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[model:");
        localStringBuilder2.append((String)localObject);
        localStringBuilder2.append("],");
        localStringBuilder1.append(localStringBuilder2.toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[platform:");
        ((StringBuilder)localObject).append(getPlatformId());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[operator:");
        ((StringBuilder)localObject).append(getOperator());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[subcoopId:");
        ((StringBuilder)localObject).append(getSubCoopId());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[udid:");
        ((StringBuilder)localObject).append(getUdid());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[userId:");
        ((StringBuilder)localObject).append(getUserId());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[userName:");
        ((StringBuilder)localObject).append(getUserName());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[time:");
        ((StringBuilder)localObject).append(getTime());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[timeCost:");
        ((StringBuilder)localObject).append(getTimeCost());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[sso_tk:");
        ((StringBuilder)localObject).append(getSso_tk());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[from:");
        ((StringBuilder)localObject).append(getFrom());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mac:");
        ((StringBuilder)localObject).append(getMac());
        ((StringBuilder)localObject).append("],");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
        return localStringBuilder1.toString();
    }
}
