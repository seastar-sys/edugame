package com.dimple.project.member.errorItem.controller;



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

import com.dimple.project.member.errorItem.entity.EduErrorItem;
import com.dimple.project.member.errorItem.service.EduErrorItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduErrorItem)表控制层
 *
 * @author 刘登辉
 * @since 2020-04-04 00:44:14
 */
@Controller
@RequestMapping("eduErrorItem")
public class EduErrorItemController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private EduErrorItemService eduErrorItemService;

    /**
     * 分页查询所有数据
     *
     * @param eduErrorItem 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduErrorItem eduErrorItem) {
        startPage();
        List<EduErrorItem> list = this.eduErrorItemService.selectEduErrorItem(eduErrorItem);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduErrorItem
     * @return
     */
    @Log(title = "新增eduErrorItem", businessType = BusinessType.INSERT)
    @RequiresPermissions(":add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduErrorItem eduErrorItem){
        return toAjax(this.eduErrorItemService.insertEduErrorItem(eduErrorItem));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduErrorItem", businessType = BusinessType.DELETE)
    @RequiresPermissions(":removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduErrorItemService.deleteEduErrorItemByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduErrorItem", businessType = BusinessType.DELETE)
    @RequiresPermissions(":remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduErrorItemService.deleteEduErrorItemById(id));
    }
    /***
     * 修改
     * @param eduErrorItem
     * @return
     */
    @Log(title = "修改eduErrorItem", businessType = BusinessType.UPDATE)
    @RequiresPermissions(":update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduErrorItem eduErrorItem){
        return toAjax(this.eduErrorItemService.updateEduErrorItem(eduErrorItem));
    }

}