package com.dimple.project.member.punch.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dimple.common.utils.security.ShiroUtils;
import com.dimple.framework.aspectj.lang.annotation.Log;
import com.dimple.framework.aspectj.lang.enums.BusinessType;
import com.dimple.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.dimple.framework.web.domain.AjaxResult;
import com.dimple.framework.web.page.TableDataInfo;

import com.dimple.project.member.punch.entity.EduPunch;
import com.dimple.project.member.punch.service.EduPunchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduPunch)表控制层
 *
 * @author 刘登辉
 * @since 2020-03-30 18:03:32
 */
@Controller
@RequestMapping("eduPunch")
public class EduPunchController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private EduPunchService eduPunchService;

    /**
     * 分页查询所有数据
     *
     * @param eduPunch 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduPunch eduPunch) {
        startPage();
        List<EduPunch> list = this.eduPunchService.selectEduPunch(eduPunch);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduPunch
     * @return
     */
    @Log(title = "新增eduPunch", businessType = BusinessType.INSERT)
    @RequiresPermissions(":add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduPunch eduPunch){
        return toAjax(this.eduPunchService.insertEduPunch(eduPunch));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduPunch", businessType = BusinessType.DELETE)
    @RequiresPermissions(":removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduPunchService.deleteEduPunchByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduPunch", businessType = BusinessType.DELETE)
    @RequiresPermissions(":remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduPunchService.deleteEduPunchById(id));
    }
    /***
     * 修改
     * @param eduPunch
     * @return
     */
    @Log(title = "修改eduPunch", businessType = BusinessType.UPDATE)
    @RequiresPermissions(":update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduPunch eduPunch){
        return toAjax(this.eduPunchService.updateEduPunch(eduPunch));
    }

}