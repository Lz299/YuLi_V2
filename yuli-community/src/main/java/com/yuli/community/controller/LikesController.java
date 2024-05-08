package com.yuli.community.controller;

import java.util.List;
import java.util.Map;
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
import com.yuli.community.domain.Likes;
import com.yuli.community.service.ILikesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 点赞管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/community/likes")
@Anonymous
public class LikesController extends BaseController
{
    @Autowired
    private ILikesService likesService;

    /**
     * 查询点赞管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Likes likes)
    {
        startPage();
        List<Likes> list = likesService.selectLikesList(likes);
        return getDataTable(list);
    }

    /**
     * 导出点赞管理列表
     */

    @Log(title = "点赞管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Likes likes)
    {
        List<Likes> list = likesService.selectLikesList(likes);
        ExcelUtil<Likes> util = new ExcelUtil<Likes>(Likes.class);
        util.exportExcel(response, list, "点赞管理数据");
    }

    /**
     * 获取点赞管理详细信息
     */

    @GetMapping(value = "/{likesId}")
    public AjaxResult getInfo(@PathVariable("likesId") Long likesId)
    {
        return success(likesService.selectLikesByLikesId(likesId));
    }

    /**
     * 新增点赞管理
     */

    @Log(title = "点赞管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Likes likes)
    {
        return toAjax(likesService.insertLikes(likes));
    }

    /**
     * 修改点赞管理
     */

    @Log(title = "点赞管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Likes likes)
    {
        return toAjax(likesService.updateLikes(likes));
    }

    /**
     * 删除点赞管理
     */

    @Log(title = "点赞管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{likesIds}")
    public AjaxResult remove(@PathVariable Long[] likesIds)
    {
        return toAjax(likesService.deleteLikesByLikesIds(likesIds));
    }





}
