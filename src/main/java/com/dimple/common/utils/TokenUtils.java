package com.dimple.common.utils;

import com.dimple.project.member.user.entity.EduUser;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TokenUtils {
    /**
     * 生成token放入redis
     */
    public String  createToken(EduUser member){
        String token = TokenProccessor.getInstance().makeToken();
        String old = member.getToken();
        if(old!=null){//已登录
            if(RedisUtils.getRedisUtils().hasKey(old)){//未失效
                if(RedisUtils.getRedisUtils().delete(old)){//删除
                    ArrayList<Map<String, Object>> dataStr = new ArrayList<>();
                    member.setToken(token);
                    dataStr.add(member.getMap());
                    RedisUtils.getRedisUtils().getValueOperations().set(token,dataStr,1, TimeUnit.DAYS);//新增
                    if(RedisUtils.getRedisUtils().hasKey(token)){
                        return token;
                    }
                }
            }
        }
        ArrayList<Map<String, Object>> dataStr = new ArrayList<>();
        member.setToken(token);
        dataStr.add(member.getMap());
        RedisUtils.getRedisUtils().getValueOperations().set(token,dataStr,1, TimeUnit.DAYS);//新增
        if(RedisUtils.getRedisUtils().hasKey(token)){
            return token;
        }else{
            return null;
        }
    }

    /**
     * 移除token
     */
    public boolean removeToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return RedisUtils.getRedisUtils().delete(token);
    }

    /**
     * 判断请求参数中的token是否和session中一致
     * @param request
     * @return
     */
    public boolean TokenIs(HttpServletRequest request){
        String token = request.getHeader("token");
        return RedisUtils.getRedisUtils().hasKey(token);
    }

    /***
     * 是否在线
     * @param token
     * @return
     */
    public boolean TokenOnle(String token){
        return RedisUtils.getRedisUtils().hasKey(token);
    }
}
