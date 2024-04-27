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
import com.yuli.clothes.domain.Ornament;
import com.yuli.clothes.service.IOrnamentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 装饰管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/clothes/ornament")
public class OrnamentController extends BaseController
{
    @Autowired
    private IOrnamentService ornamentService;

    /**
     * 查询装饰管理列表
     */
    @PreAuthorize("@ss.hasPermi('clothes:ornament:list')")
    @GetMapping("/list")
    public TableDataInfo list(Ornament ornament)
    {
        startPage();
        List<Ornament> list = ornamentService.selectOrnamentList(ornament);
        return getDataTable(list);
    }

    /**
     * 导出装饰管理列表
     */
    @PreAuthorize("@ss.hasPermi('clothes:ornament:export')")
    @Log(title = "装饰管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Ornament ornament)
    {
        List<Ornament> list = ornamentService.selectOrnamentList(ornament);
        ExcelUtil<Ornament> util = new ExcelUtil<Ornament>(Ornament.class);
        util.exportExcel(response, list, "装饰管理数据");
    }

    /**
     * 获取装饰管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('clothes:ornament:query')")
    @GetMapping(value = "/{ornamentId}")
    public AjaxResult getInfo(@PathVariable("ornamentId") Long ornamentId)
    {
        return success(ornamentService.selectOrnamentByOrnamentId(ornamentId));
    }

    /**
     * 新增装饰管理
     */
    @PreAuthorize("@ss.hasPermi('clothes:ornament:add')")
    @Log(title = "装饰管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Ornament ornament)
    {
        return toAjax(ornamentService.insertOrnament(ornament));
    }

    /**
     * 修改装饰管理
     */
    @PreAuthorize("@ss.hasPermi('clothes:ornament:edit')")
    @Log(title = "装饰管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Ornament ornament)
    {
        return toAjax(ornamentService.updateOrnament(ornament));
    }

    /**
     * 删除装饰管理
     */
    @PreAuthorize("@ss.hasPermi('clothes:ornament:remove')")
    @Log(title = "装饰管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ornamentIds}")
    public AjaxResult remove(@PathVariable Long[] ornamentIds)
    {
        return toAjax(ornamentService.deleteOrnamentByOrnamentIds(ornamentIds));
    }
}
