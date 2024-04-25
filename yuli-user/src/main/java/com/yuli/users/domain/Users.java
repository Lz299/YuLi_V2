package com.yuli.users.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 屿里用户对象 users
 * 
 * @author lz
 * @date 2024-04-25
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long usersId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String usersName;

    /** 密码 */
    @Excel(name = "密码")
    private String usersPassword;

    /** 性别 */
    @Excel(name = "性别")
    private String usersSex;

    /** 手机号 */
    @Excel(name = "手机号")
    private String usersPhone;

    /** 头像 */
    @Excel(name = "头像")
    private String usersImage;

    /** 角色 */
    @Excel(name = "角色")
    private String role;

    /** 状态 */
    @Excel(name = "状态")
    private String usersStatus;

    /** 身材id */
    @Excel(name = "身材id")
    private Long statureId;

    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setUsersName(String usersName) 
    {
        this.usersName = usersName;
    }

    public String getUsersName() 
    {
        return usersName;
    }
    public void setUsersPassword(String usersPassword) 
    {
        this.usersPassword = usersPassword;
    }

    public String getUsersPassword() 
    {
        return usersPassword;
    }
    public void setUsersSex(String usersSex) 
    {
        this.usersSex = usersSex;
    }

    public String getUsersSex() 
    {
        return usersSex;
    }
    public void setUsersPhone(String usersPhone) 
    {
        this.usersPhone = usersPhone;
    }

    public String getUsersPhone() 
    {
        return usersPhone;
    }
    public void setUsersImage(String usersImage) 
    {
        this.usersImage = usersImage;
    }

    public String getUsersImage() 
    {
        return usersImage;
    }
    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getRole() 
    {
        return role;
    }
    public void setUsersStatus(String usersStatus) 
    {
        this.usersStatus = usersStatus;
    }

    public String getUsersStatus() 
    {
        return usersStatus;
    }
    public void setStatureId(Long statureId) 
    {
        this.statureId = statureId;
    }

    public Long getStatureId() 
    {
        return statureId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("usersId", getUsersId())
            .append("usersName", getUsersName())
            .append("usersPassword", getUsersPassword())
            .append("usersSex", getUsersSex())
            .append("usersPhone", getUsersPhone())
            .append("usersImage", getUsersImage())
            .append("role", getRole())
            .append("usersStatus", getUsersStatus())
            .append("statureId", getStatureId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
