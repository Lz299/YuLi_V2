package com.yuli.users.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yuli.users.domain.Users;
import com.yuli.users.service.IUsersService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 屿里用户Controller
 * 
 * @author lz
 * @date 2024-04-25
 */
@RestController
@RequestMapping("/users/users")
public class UsersController extends BaseController
{
    @Autowired
    private IUsersService ylUserService;

    /**
     * 查询屿里用户列表
     */
    @PreAuthorize("@ss.hasPermi('users:users:list')")
    @GetMapping("/list")
    public TableDataInfo list(Users users)
    {
        startPage();
        List<Users> list = ylUserService.selectUsersList(users);
        return getDataTable(list);
    }

    /**
     * 导出屿里用户列表
     */
    @PreAuthorize("@ss.hasPermi('users:users:export')")
    @Log(title = "屿里用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Users users)
    {
        List<Users> list = ylUserService.selectUsersList(users);
        ExcelUtil<Users> util = new ExcelUtil<Users>(Users.class);
        util.exportExcel(response, list, "屿里用户数据");
    }

    /**
     * 获取屿里用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:users:query')")
    @GetMapping(value = "/{usersId}")
    public AjaxResult getInfo(@PathVariable("usersId") Long usersId)
    {
        return success(ylUserService.selectUsersByUsersId(usersId));
    }

    /**
     * 新增屿里用户
     */
    @PreAuthorize("@ss.hasPermi('users:users:add')")
    @Log(title = "屿里用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Users users)
    {
        return toAjax(ylUserService.insertUsers(users));
    }

    /**
     * 修改屿里用户
     */
    @PreAuthorize("@ss.hasPermi('users:users:edit')")
    @Log(title = "屿里用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Users users)
    {
        return toAjax(ylUserService.updateUsers(users));
    }

    /**
     * 删除屿里用户
     */
    @PreAuthorize("@ss.hasPermi('users:users:remove')")
    @Log(title = "屿里用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{usersIds}")
    public AjaxResult remove(@PathVariable Long[] usersIds)
    {
        return toAjax(ylUserService.deleteUsersByUsersIds(usersIds));
    }
}
