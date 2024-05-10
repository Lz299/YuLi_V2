package com.yuli.users.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;

import com.ruoyi.common.annotation.Anonymous;
import com.yuli.users.domain.Result;
import com.yuli.users.domain.Users;
import com.yuli.users.service.IUsersService;
import com.yuli.users.utils.JwtUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
@Anonymous
public class UsersController extends BaseController
{
    @Autowired
    private IUsersService ylUserService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 查询屿里用户列表
     */

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

    @GetMapping(value = "/{usersId}")
    public AjaxResult getInfo(@PathVariable("usersId") Long usersId)
    {
        return success(ylUserService.selectUsersByUsersId(usersId));
    }

    /**
     * 新增屿里用户
     */

    @Log(title = "屿里用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Users users)
    {
        return toAjax(ylUserService.insertUsers(users));
    }

    /**
     * 修改屿里用户
     */

    @Log(title = "屿里用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Users users)
    {
        return toAjax(ylUserService.updateUsers(users));
    }

    /**
     * 删除屿里用户
     */

    @Log(title = "屿里用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{usersIds}")
    public AjaxResult remove(@PathVariable Long[] usersIds)
    {
        return toAjax(ylUserService.deleteUsersByUsersIds(usersIds));
    }




    @PostMapping("/login")
    public Result<Users> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password)
    {
        Users loginUser = ylUserService.login(username);
        System.out.println(username);
        System.out.println(password);
        if(loginUser==null){
            return Result.error("用户名错误");
        }
        if (password.equals(loginUser.getUsersPassword())){

            Map<String,Object> map=new HashMap<>();
            map.put("id",loginUser.getUsersId());
            map.put("username",loginUser.getUsersName());
            String token= JwtUtil.genToken(map);

            //tokrn -> redis
            ValueOperations<String,String> vo=stringRedisTemplate.opsForValue();
            vo.set("token",token,1, TimeUnit.HOURS);

            return Result.success(loginUser);
        }

        return Result.error("密码错误");
    }

    @PostMapping("/update")
    public Result<String> updatePassword(@RequestBody Users users,String qrpassword){
        ylUserService.updatePassword(users,qrpassword);
        return Result.success("修改成功");
    }


}
