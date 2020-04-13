package com.dimple.project.member.itemBank.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dimple.common.constant.BlogConstants;
import com.dimple.common.utils.security.ShiroUtils;
import com.dimple.framework.aspectj.lang.annotation.Log;
import com.dimple.framework.aspectj.lang.enums.BusinessType;
import com.dimple.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.dimple.framework.web.domain.AjaxResult;
import com.dimple.framework.web.page.TableDataInfo;

import com.dimple.project.member.itemBank.entity.EduItemBank;
import com.dimple.project.member.itemBank.service.EduItemBankService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (EduItemBank)表控制层
 *
 * @author 刘登辉
 * @since 2020-03-31 15:43:40
 */
@Controller
@RequestMapping("/item")
public class EduItemBankController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private EduItemBankService eduItemBankService;

    @RequiresPermissions("item:item:view")
    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("total", 0);
        model.addAttribute("published", 1);
        model.addAttribute("draft", 2);
        model.addAttribute("garbage", 3);
        return "member/itembank/itembank";
    }
    @RequiresPermissions("item:item:add")
    @GetMapping("/add")
    public String add(Model model) {
        return "member/itembank/add";
    }
    /**
     * 分页查询所有数据
     *
     * @param eduItemBank 查询实体
     * @return 所有数据
     */
    @RequiresPermissions("item:item:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(EduItemBank eduItemBank) {
        startPage();
        List<EduItemBank> list = this.eduItemBankService.selectEduItemBank(eduItemBank);
        return getDataTable(list);
    }
    /***
     * 新增
     * @param eduItemBank
     * @return
     */
    @Log(title = "新增eduItemBank", businessType = BusinessType.INSERT)
    @RequiresPermissions("item:item:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EduItemBank eduItemBank){
        return toAjax(this.eduItemBankService.insertEduItemBank(eduItemBank));
    }
    /***
     * 批量删除
     * @param ids
     * @return
     */
    @Log(title = "删除eduItemBank", businessType = BusinessType.DELETE)
    @RequiresPermissions("item:item:removes")
    @DeleteMapping("/removes")
    @ResponseBody
    public AjaxResult removes(Integer[] ids){
        return toAjax(this.eduItemBankService.deleteEduItemBankByIds(ids));
    }
    
      /***
     * 通过id删除
     * @param id
     * @return
     */
    @Log(title = "删除eduItemBank", businessType = BusinessType.DELETE)
    @RequiresPermissions("item:item:remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Integer id){
        return toAjax(this.eduItemBankService.deleteEduItemBankById(id));
    }
    /***
     * 修改
     * @param eduItemBank
     * @return
     */
    @Log(title = "修改eduItemBank", businessType = BusinessType.UPDATE)
    @RequiresPermissions("item:item:update")
    @DeleteMapping("/update")
    @ResponseBody
    public AjaxResult update(EduItemBank eduItemBank){
        return toAjax(this.eduItemBankService.updateEduItemBank(eduItemBank));
    }

}