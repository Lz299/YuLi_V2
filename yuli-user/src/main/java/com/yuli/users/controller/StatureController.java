package com.yuli.users.controller;

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
import com.yuli.users.domain.Stature;
import com.yuli.users.service.IStatureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 身材管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/users/stature")
@Anonymous
public class StatureController extends BaseController
{
    @Autowired
    private IStatureService statureService;

    /**
     * 查询身材管理列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Stature stature)
    {
        startPage();
        List<Stature> list = statureService.selectStatureList(stature);
        return getDataTable(list);
    }

    /**
     * 导出身材管理列表
     */

    @Log(title = "身材管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Stature stature)
    {
        List<Stature> list = statureService.selectStatureList(stature);
        ExcelUtil<Stature> util = new ExcelUtil<Stature>(Stature.class);
        util.exportExcel(response, list, "身材管理数据");
    }

    /**
     * 获取身材管理详细信息
     */

    @GetMapping(value = "/{statureId}")
    public AjaxResult getInfo(@PathVariable("statureId") Long statureId)
    {
        return success(statureService.selectStatureByStatureId(statureId));
    }

    /**
     * 新增身材管理
     */

    @Log(title = "身材管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stature stature)
    {
        return toAjax(statureService.insertStature(stature));
    }

    /**
     * 修改身材管理
     */

    @Log(title = "身材管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stature stature)
    {
        return toAjax(statureService.updateStature(stature));
    }

    /**
     * 删除身材管理
     */

    @Log(title = "身材管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{statureIds}")
    public AjaxResult remove(@PathVariable Long[] statureIds)
    {
        return toAjax(statureService.deleteStatureByStatureIds(statureIds));
    }
}
