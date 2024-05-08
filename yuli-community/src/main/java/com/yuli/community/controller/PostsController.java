package com.yuli.community.controller;

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
import com.yuli.community.domain.Posts;
import com.yuli.community.service.IPostsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帖子管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/community/posts")
public class PostsController extends BaseController
{
    @Autowired
    private IPostsService postsService;

    /**
     * 查询帖子管理列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Posts posts)
    {
        startPage();
        List<Posts> list = postsService.selectPostsList(posts);
        return getDataTable(list);
    }

    /**
     * 导出帖子管理列表
     */

    @Log(title = "帖子管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Posts posts)
    {
        List<Posts> list = postsService.selectPostsList(posts);
        ExcelUtil<Posts> util = new ExcelUtil<Posts>(Posts.class);
        util.exportExcel(response, list, "帖子管理数据");
    }

    /**
     * 获取帖子管理详细信息
     */

    @GetMapping(value = "/{postsId}")
    public AjaxResult getInfo(@PathVariable("postsId") Long postsId)
    {
        return success(postsService.selectPostsByPostsId(postsId));
    }

    /**
     * 新增帖子管理
     */

    @Log(title = "帖子管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Posts posts)
    {
        return toAjax(postsService.insertPosts(posts));
    }

    /**
     * 修改帖子管理
     */

    @Log(title = "帖子管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Posts posts)
    {
        return toAjax(postsService.updatePosts(posts));
    }

    /**
     * 删除帖子管理
     */

    @Log(title = "帖子管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postsIds}")
    public AjaxResult remove(@PathVariable Long[] postsIds)
    {
        return toAjax(postsService.deletePostsByPostsIds(postsIds));
    }

    @GetMapping("/findpost")
    public List<Posts> findPostAll(){
        return postsService.findAll();
    }



    public List<Posts> selectPostsListByUserId(String users_id){
        return postsService.selectPostsListByUserId(users_id);
    }

    public int updatePostsByUserId(Posts posts){
        return postsService.updatePostsByUserId(posts);
    }
}
