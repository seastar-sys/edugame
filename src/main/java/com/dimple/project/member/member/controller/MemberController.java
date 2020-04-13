package com.dimple.project.member.member.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dimple.common.utils.AndroidHttpUtil;
import com.dimple.common.utils.security.ShiroUtils;
import com.dimple.framework.aspectj.lang.annotation.Log;
import com.dimple.framework.aspectj.lang.enums.BusinessType;
import com.dimple.framework.web.controller.BaseController;
import com.dimple.framework.web.domain.AjaxResult;
import com.dimple.framework.web.page.TableDataInfo;
import com.dimple.project.member.member.domain.MemberUser;
import com.dimple.project.member.member.service.MemberUserService;
import okhttp3.RequestBody;
import okhttp3.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * @className: JobLogController
 * @description: 调度日志操作处理
 * @auther: Dimple
 * @Date: 2019/3/13
 * @Version: 1.1
 */
@Controller
@RequestMapping("/member/member")
public class MemberController extends BaseController {
    private String prefix = "member/member";

    @Autowired
    private MemberUserService memberUserService;

    @RequiresPermissions("member:member:view")
    @GetMapping()
    public String index() {
        return prefix + "/member";
    }

    @RequiresPermissions("member:member:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(MemberUser robot) {
        startPage();
        List<MemberUser> list = memberUserService.selectRobotUserList(robot);
        return getDataTable(list);
    }


    /***
     * 新增机器人
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        MemberUser robot = new MemberUser();
        robot.setNumber(uuid());
        while (memberUserService.selectRobotUserList(robot).size()!=0){//检测随机数是否是唯一的
            robot.setNumber(uuid());//随机数不唯一继续生成
        }
        robot.setPassword(getChar(8));
        model.addAttribute("robot", robot);
        return prefix + "/add";
    }

    @Log(title = "新增机器人", businessType = BusinessType.INSERT)
    @RequiresPermissions("robot:robot:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MemberUser robot){
        robot.setMquser(robot.getNumber());
        robot.setMqpwd(robot.getPassword());
        robot.setMqsend("robot");
        robot.setMqpublic(robot.getNumber());
        robot.setCreateBy(ShiroUtils.getLoginName());
        robot.setState("1");
        return toAjax(memberUserService.insertRobotUser(robot));
    }

    @Log(title = "删除机器人", businessType = BusinessType.DELETE)
    @RequiresPermissions("robot:robot:remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer[] ids){
        return toAjax(memberUserService.deleteRobotUserByIds(ids));
    }
    /**
     * 随机生成账号
     * @return
     */
    public static String uuid(){
        int first = new Random().nextInt(9);
        int rnd = UUID.randomUUID().toString().hashCode();
        if(rnd < 0){
            rnd = -rnd;
        }
        return first+String.format("%010d", rnd);
    }
    public static String getChar(int length) {
        char[] ss = new char[length];
        int i=0;
        while(i<length) {
            int f = (int) (Math.random()*3);
            if(f==0)
                ss[i] = (char) ('A'+Math.random()*26);
            else if(f==1)
                ss[i] = (char) ('a'+Math.random()*26);
            else
                ss[i] = (char) ('0'+Math.random()*10);
            i++;
        }
        String str=new String(ss);
        return str;
    }
}
