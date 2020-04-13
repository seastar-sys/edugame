package com.dimple.project.robot.robot.domain;

import java.util.Map;

/**
 * Created by Administrator on 2019/11/20 0020.
 */

public class RequestBody
{
    private Map<String, Object> data;
    private String sid;

    public Map<String, Object> getData()
    {
        return this.data;
    }

    public String getSid()
    {
        return this.sid;
    }

    public void setData(Map<String, Object> paramMap)
    {
        this.data = paramMap;
    }

    public void setSid(String paramString)
    {
        this.sid = paramString;
    }
}
