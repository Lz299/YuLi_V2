package com.yuli.users.service;

import com.yuli.users.domain.Users;
import java.util.List;

/**
 * 屿里用户Service接口
 * 
 * @author lz
 * @date 2024-04-25
 */

public interface IUsersService 
{
    /**
     * 查询屿里用户
     * 
     * @param usersId 屿里用户主键
     * @return 屿里用户
     */
    public Users selectUsersByUsersId(Long usersId);

    /**
     * 查询屿里用户列表
     * 
     * @param users 屿里用户
     * @return 屿里用户集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增屿里用户
     * 
     * @param users 屿里用户
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改屿里用户
     * 
     * @param users 屿里用户
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 批量删除屿里用户
     * 
     * @param usersIds 需要删除的屿里用户主键集合
     * @return 结果
     */
    public int deleteUsersByUsersIds(Long[] usersIds);

    /**
     * 删除屿里用户信息
     * 
     * @param usersId 屿里用户主键
     * @return 结果
     */
    public int deleteUsersByUsersId(Long usersId);

    Users login(String username);


    String updatePassword(Users users, String qrPassword);
}
