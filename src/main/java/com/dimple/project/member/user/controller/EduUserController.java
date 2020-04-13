package com.dimple.project.member.user.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dimple.common.utils.AndroidHttpUtil;
import com.dimple.common.utils.security.ShiroUtils;
import com.dimple.framework.aspectj.lang.annotation.Log;
import com.dimple.framework.aspectj.lang.enums.BusinessType;
import com.dimple.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.dimple.framework.web.domain.AjaxResult;
import com.dimple.framework.web.page.TableDataInfo;

import com.dimple.project.member.user.entity.EduUser;
import com.dimple.project.member.user.service.EduUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduUser)表控制层
 *
 * @author 刘登辉
 * @since 2020-03-10 17:57:10
 */
@Controller
@RequestMapping("eduUser")
public class EduUserController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private EduUserService eduUserService;

    /**
     * 分页查询所有数据
     *
     * @param eduUser 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduUser eduUser) {
        startPage();
        List<EduUser> list = this.eduUserService.selectEduUser(eduUser);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduUser
     * @return
     */
    @Log(title = "新增eduUser", businessType = BusinessType.INSERT)
    @RequiresPermissions(":add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduUser eduUser){
        return toAjax(this.eduUserService.insertEduUser(eduUser));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduUser", businessType = BusinessType.DELETE)
    @RequiresPermissions(":removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduUserService.deleteEduUserByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduUser", businessType = BusinessType.DELETE)
    @RequiresPermissions(":remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduUserService.deleteEduUserById(id));
    }
    /***
     * 修改
     * @param eduUser
     * @return
     */
    @Log(title = "修改eduUser", businessType = BusinessType.UPDATE)
    @RequiresPermissions(":update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduUser eduUser){
        return toAjax(this.eduUserService.updateEduUser(eduUser));
    }

}