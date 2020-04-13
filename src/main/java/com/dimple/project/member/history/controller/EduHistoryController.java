package com.dimple.project.member.history.controller;



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

import com.dimple.project.member.history.entity.EduHistory;
import com.dimple.project.member.history.service.EduHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduHistory)表控制层
 *
 * @author 刘登辉
 * @since 2020-03-30 14:20:15
 */
@Controller
@RequestMapping("eduHistory")
public class EduHistoryController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private EduHistoryService eduHistoryService;

    /**
     * 分页查询所有数据
     *
     * @param eduHistory 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduHistory eduHistory) {
        startPage();
        List<EduHistory> list = this.eduHistoryService.selectEduHistory(eduHistory);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduHistory
     * @return
     */
    @Log(title = "新增eduHistory", businessType = BusinessType.INSERT)
    @RequiresPermissions(":add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduHistory eduHistory){
        return toAjax(this.eduHistoryService.insertEduHistory(eduHistory));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduHistory", businessType = BusinessType.DELETE)
    @RequiresPermissions(":removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduHistoryService.deleteEduHistoryByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduHistory", businessType = BusinessType.DELETE)
    @RequiresPermissions(":remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduHistoryService.deleteEduHistoryById(id));
    }
    /***
     * 修改
     * @param eduHistory
     * @return
     */
    @Log(title = "修改eduHistory", businessType = BusinessType.UPDATE)
    @RequiresPermissions(":update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduHistory eduHistory){
        return toAjax(this.eduHistoryService.updateEduHistory(eduHistory));
    }

}