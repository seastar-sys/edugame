package com.dimple.project.member.order.controller;



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

import com.dimple.project.member.order.entity.EduOrder;
import com.dimple.project.member.order.service.EduOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduOrder)表控制层
 *
 * @author 刘登辉
 * @since 2020-03-10 22:36:36
 */
@Controller
@RequestMapping("eduOrder")
public class EduOrderController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private EduOrderService eduOrderService;

    /**
     * 分页查询所有数据
     *
     * @param eduOrder 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduOrder eduOrder) {
        startPage();
        List<EduOrder> list = this.eduOrderService.selectEduOrder(eduOrder);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduOrder
     * @return
     */
    @Log(title = "新增eduOrder", businessType = BusinessType.INSERT)
    @RequiresPermissions(":add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduOrder eduOrder){
        return toAjax(this.eduOrderService.insertEduOrder(eduOrder));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduOrder", businessType = BusinessType.DELETE)
    @RequiresPermissions(":removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduOrderService.deleteEduOrderByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduOrder", businessType = BusinessType.DELETE)
    @RequiresPermissions(":remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduOrderService.deleteEduOrderById(id));
    }
    /***
     * 修改
     * @param eduOrder
     * @return
     */
    @Log(title = "修改eduOrder", businessType = BusinessType.UPDATE)
    @RequiresPermissions(":update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduOrder eduOrder){
        return toAjax(this.eduOrderService.updateEduOrder(eduOrder));
    }

}