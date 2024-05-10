package com.yuli.clothes.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.yuli.clothes.domain.Pants;
import com.yuli.clothes.service.IPantsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 裤子管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/clothes/pants")
@Anonymous
public class PantsController extends BaseController
{
    @Autowired
    private IPantsService pantsService;

    /**
     * 查询裤子管理列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Pants pants)
    {
        startPage();
        List<Pants> list = pantsService.selectPantsList(pants);
        return getDataTable(list);
    }

    /**
     * 导出裤子管理列表
     */

    @Log(title = "裤子管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Pants pants)
    {
        List<Pants> list = pantsService.selectPantsList(pants);
        ExcelUtil<Pants> util = new ExcelUtil<Pants>(Pants.class);
        util.exportExcel(response, list, "裤子管理数据");
    }

    /**
     * 获取裤子管理详细信息
     */

    @GetMapping(value = "/{pantsId}")
    public AjaxResult getInfo(@PathVariable("pantsId") Long pantsId)
    {
        return success(pantsService.selectPantsByPantsId(pantsId));
    }

    /**
     * 新增裤子管理
     */

    @Log(title = "裤子管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Pants pants)
    {
        return toAjax(pantsService.insertPants(pants));
    }

    /**
     * 修改裤子管理
     */

    @Log(title = "裤子管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Pants pants)
    {
        return toAjax(pantsService.updatePants(pants));
    }

    /**
     * 删除裤子管理
     */

    @Log(title = "裤子管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pantsIds}")
    public AjaxResult remove(@PathVariable Long[] pantsIds)
    {
        return toAjax(pantsService.deletePantsByPantsIds(pantsIds));
    }
}
