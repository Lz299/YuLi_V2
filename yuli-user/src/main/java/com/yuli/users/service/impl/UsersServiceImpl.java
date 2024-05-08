package com.yuli.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.yuli.users.domain.Users;
import com.yuli.users.mapper.UsersMapper;
import com.yuli.users.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 屿里用户Service业务层处理
 * 
 * @author lz
 * @date 2024-04-25
 */
@Service("ylUserService")
public class UsersServiceImpl implements IUsersService
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询屿里用户
     * 
     * @param usersId 屿里用户主键
     * @return 屿里用户
     */
    @Override
    public Users selectUsersByUsersId(Long usersId)
    {
        return usersMapper.selectUsersByUsersId(usersId);
    }

    /**
     * 查询屿里用户列表
     * 
     * @param users 屿里用户
     * @return 屿里用户
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增屿里用户
     * 
     * @param users 屿里用户
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        users.setCreateTime(DateUtils.getNowDate());
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改屿里用户
     * 
     * @param users 屿里用户
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        users.setUpdateTime(DateUtils.getNowDate());
        return usersMapper.updateUsers(users);
    }

    /**
     * 批量删除屿里用户
     * 
     * @param usersIds 需要删除的屿里用户主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUsersIds(Long[] usersIds)
    {
        return usersMapper.deleteUsersByUsersIds(usersIds);
    }

    /**
     * 删除屿里用户信息
     * 
     * @param usersId 屿里用户主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUsersId(Long usersId)
    {
        return usersMapper.deleteUsersByUsersId(usersId);
    }

    @Override
    public Users login(String username) {
            Users loginUsers =usersMapper.login(username);
        if (loginUsers != null) {

            return loginUsers;
        }
        return null;
    }


    @Override
    public String updatePassword(Users users, String qrPassword) {

        Users oldUsers=usersMapper.selectUsersByUsersId(users.getUsersId());
        if (!qrPassword.equals(users.getUsersPassword())){
            return "俩次密码不一致";
        }
        if (!oldUsers.getUsersPassword().equals(users.getUsersPassword())){
            return "新密码不能与旧密码一致";
        }
        users.setUpdateTime(DateUtils.getNowDate());
        usersMapper.updateUsers(users);
        return "修改成功";
    }
}
