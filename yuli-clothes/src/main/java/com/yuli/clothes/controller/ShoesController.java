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
import com.yuli.clothes.domain.Shoes;
import com.yuli.clothes.service.IShoesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 鞋子管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/clothes/shoes")
public class ShoesController extends BaseController
{
    @Autowired
    private IShoesService shoesService;

    /**
     * 查询鞋子管理列表
     */
    @PreAuthorize("@ss.hasPermi('clothes:shoes:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shoes shoes)
    {
        startPage();
        List<Shoes> list = shoesService.selectShoesList(shoes);
        return getDataTable(list);
    }

    /**
     * 导出鞋子管理列表
     */
    @PreAuthorize("@ss.hasPermi('clothes:shoes:export')")
    @Log(title = "鞋子管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Shoes shoes)
    {
        List<Shoes> list = shoesService.selectShoesList(shoes);
        ExcelUtil<Shoes> util = new ExcelUtil<Shoes>(Shoes.class);
        util.exportExcel(response, list, "鞋子管理数据");
    }

    /**
     * 获取鞋子管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('clothes:shoes:query')")
    @GetMapping(value = "/{shoesId}")
    public AjaxResult getInfo(@PathVariable("shoesId") Long shoesId)
    {
        return success(shoesService.selectShoesByShoesId(shoesId));
    }

    /**
     * 新增鞋子管理
     */
    @PreAuthorize("@ss.hasPermi('clothes:shoes:add')")
    @Log(title = "鞋子管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shoes shoes)
    {
        return toAjax(shoesService.insertShoes(shoes));
    }

    /**
     * 修改鞋子管理
     */
    @PreAuthorize("@ss.hasPermi('clothes:shoes:edit')")
    @Log(title = "鞋子管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shoes shoes)
    {
        return toAjax(shoesService.updateShoes(shoes));
    }

    /**
     * 删除鞋子管理
     */
    @PreAuthorize("@ss.hasPermi('clothes:shoes:remove')")
    @Log(title = "鞋子管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shoesIds}")
    public AjaxResult remove(@PathVariable Long[] shoesIds)
    {
        return toAjax(shoesService.deleteShoesByShoesIds(shoesIds));
    }
}
