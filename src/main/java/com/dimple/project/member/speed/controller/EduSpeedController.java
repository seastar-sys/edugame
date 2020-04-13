package com.dimple.project.member.speed.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dimple.common.utils.AndroidHttpUtil;
import com.dimple.common.utils.security.ShiroUtils;
import com.dimple.framework.aspectj.lang.annotation.Log;
import com.dimple.framework.aspectj.lang.enums.BusinessType;
import com.dimple.framework.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.dimple.framework.web.domain.AjaxResult;
import com.dimple.framework.web.page.TableDataInfo;

import com.dimple.project.member.speed.entity.EduSpeed;
import com.dimple.project.member.speed.service.EduSpeedService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduSpeed)表控制层
 *
 * @author 刘登辉
 * @since 2020-03-04 18:48:25
 */
@RestController
@RequestMapping("eduSpeed")
public class EduSpeedController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private EduSpeedService eduSpeedService;

    /**
     * 分页查询所有数据
     *
     * @param eduSpeed 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduSpeed eduSpeed) {
        startPage();
        List<EduSpeed> list = this.eduSpeedService.selectEduSpeed(eduSpeed);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduSpeed
     * @return
     */
    @Log(title = "新增eduSpeed", businessType = BusinessType.INSERT)
    @RequiresPermissions(":add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduSpeed eduSpeed){
        return toAjax(this.eduSpeedService.insertEduSpeed(eduSpeed));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduSpeed", businessType = BusinessType.DELETE)
    @RequiresPermissions(":removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduSpeedService.deleteEduSpeedByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduSpeed", businessType = BusinessType.DELETE)
    @RequiresPermissions(":remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduSpeedService.deleteEduSpeedById(id));
    }
    /***
     * 修改
     * @param eduSpeed
     * @return
     */
    @Log(title = "修改eduSpeed", businessType = BusinessType.UPDATE)
    @RequiresPermissions(":update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduSpeed eduSpeed){
        return toAjax(this.eduSpeedService.updateEduSpeed(eduSpeed));
    }

}