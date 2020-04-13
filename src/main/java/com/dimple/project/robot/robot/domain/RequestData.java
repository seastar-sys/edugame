package com.dimple.project.robot.robot.domain;

/**
 * Created by Administrator on 2019/11/20 0020.
 */

public class RequestData
{
    private RequestBody body;
    private RequestHeader header;

    public RequestBody getBody()
    {
        return this.body;
    }

    public RequestHeader getHeader()
    {
        return this.header;
    }

    public void setBody(RequestBody paramRequestBody)
    {
        this.body = paramRequestBody;
    }

    public void setHeader(RequestHeader paramRequestHeader)
    {
        this.header = paramRequestHeader;
    }
}
