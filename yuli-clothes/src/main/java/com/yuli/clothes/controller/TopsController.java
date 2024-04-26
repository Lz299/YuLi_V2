package com.yuli.clothes.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.yuli.clothes.domain.Tops;
import com.yuli.clothes.service.ITopsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * topsController
 * 
 * @author lz
 * @date 2024-04-26
 */
@RestController
@RequestMapping("/clothes/tops")
public class TopsController extends BaseController
{
    @Autowired
    private ITopsService topsService;

    /**
     * 查询tops列表
     */
    @PreAuthorize("@ss.hasPermi('clothes:tops:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tops tops)
    {
        startPage();
        List<Tops> list = topsService.selectTopsList(tops);
        return getDataTable(list);
    }

    /**
     * 导出tops列表
     */
    @PreAuthorize("@ss.hasPermi('clothes:tops:export')")
    @Log(title = "tops", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tops tops)
    {
        List<Tops> list = topsService.selectTopsList(tops);
        ExcelUtil<Tops> util = new ExcelUtil<Tops>(Tops.class);
        util.exportExcel(response, list, "tops数据");
    }

    /**
     * 获取tops详细信息
     */
    @PreAuthorize("@ss.hasPermi('clothes:tops:query')")
    @GetMapping(value = "/{topsId}")
    public AjaxResult getInfo(@PathVariable("topsId") Long topsId)
    {
        return success(topsService.selectTopsByTopsId(topsId));
    }

    /**
     * 新增tops
     */
    @PreAuthorize("@ss.hasPermi('clothes:tops:add')")
    @Log(title = "tops", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tops tops)
    {
        return toAjax(topsService.insertTops(tops));
    }

    /**
     * 修改tops
     */
    @PreAuthorize("@ss.hasPermi('clothes:tops:edit')")
    @Log(title = "tops", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tops tops)
    {
        return toAjax(topsService.updateTops(tops));
    }

    /**
     * 删除tops
     */
    @PreAuthorize("@ss.hasPermi('clothes:tops:remove')")
    @Log(title = "tops", businessType = BusinessType.DELETE)
	@DeleteMapping("/{topsIds}")
    public AjaxResult remove(@PathVariable Long[] topsIds)
    {
        return toAjax(topsService.deleteTopsByTopsIds(topsIds));
    }
}
