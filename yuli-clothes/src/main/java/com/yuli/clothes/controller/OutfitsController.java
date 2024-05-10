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
import com.yuli.clothes.domain.Outfits;
import com.yuli.clothes.service.IOutfitsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 搭配管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/clothes/outfits")
@Anonymous
public class OutfitsController extends BaseController
{
    @Autowired
    private IOutfitsService outfitsService;

    /**
     * 查询搭配管理列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Outfits outfits)
    {
        startPage();
        List<Outfits> list = outfitsService.selectOutfitsList(outfits);
        return getDataTable(list);
    }

    /**
     * 导出搭配管理列表
     */

    @Log(title = "搭配管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Outfits outfits)
    {
        List<Outfits> list = outfitsService.selectOutfitsList(outfits);
        ExcelUtil<Outfits> util = new ExcelUtil<Outfits>(Outfits.class);
        util.exportExcel(response, list, "搭配管理数据");
    }

    /**
     * 获取搭配管理详细信息
     */

    @GetMapping(value = "/{outfitsId}")
    public AjaxResult getInfo(@PathVariable("outfitsId") Long outfitsId)
    {
        return success(outfitsService.selectOutfitsByOutfitsId(outfitsId));
    }

    /**
     * 新增搭配管理
     */

    @Log(title = "搭配管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Outfits outfits)
    {
        return toAjax(outfitsService.insertOutfits(outfits));
    }

    /**
     * 修改搭配管理
     */

    @Log(title = "搭配管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Outfits outfits)
    {
        return toAjax(outfitsService.updateOutfits(outfits));
    }

    /**
     * 删除搭配管理
     */

    @Log(title = "搭配管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{outfitsIds}")
    public AjaxResult remove(@PathVariable Long[] outfitsIds)
    {
        return toAjax(outfitsService.deleteOutfitsByOutfitsIds(outfitsIds));
    }
}
