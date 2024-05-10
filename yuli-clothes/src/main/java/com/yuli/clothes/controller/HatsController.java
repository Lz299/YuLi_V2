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
import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.service.IHatsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 上衣管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/clothes/hats")
@Anonymous
public class HatsController extends BaseController
{
    @Autowired
    private IHatsService hatsService;

    /**
     * 查询上衣管理列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Hats hats)
    {
        startPage();
        List<Hats> list = hatsService.selectHatsList(hats);
        return getDataTable(list);
    }

    /**
     * 导出上衣管理列表
     */

    @Log(title = "上衣管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Hats hats)
    {
        List<Hats> list = hatsService.selectHatsList(hats);
        ExcelUtil<Hats> util = new ExcelUtil<Hats>(Hats.class);
        util.exportExcel(response, list, "上衣管理数据");
    }

    /**
     * 获取上衣管理详细信息
     */

    @GetMapping(value = "/{hatsId}")
    public AjaxResult getInfo(@PathVariable("hatsId") Long hatsId)
    {
        return success(hatsService.selectHatsByHatsId(hatsId));
    }

    /**
     * 新增上衣管理
     */

    @Log(title = "上衣管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Hats hats)
    {
        return toAjax(hatsService.insertHats(hats));
    }

    /**
     * 修改上衣管理
     */

    @Log(title = "上衣管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Hats hats)
    {
        return toAjax(hatsService.updateHats(hats));
    }

    /**
     * 删除上衣管理
     */

    @Log(title = "上衣管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hatsIds}")
    public AjaxResult remove(@PathVariable Long[] hatsIds)
    {
        return toAjax(hatsService.deleteHatsByHatsIds(hatsIds));
    }
}
