package com.yuli.clothes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 上衣管理对象 hats
 * 
 * @author lz
 * @date 2024-04-27
 */


public class Hats extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 上衣id */
    private Long hatsId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 帽子名字 */
    @Excel(name = "帽子名字")
    private String hatsName;

    /** 帽子图片 */
    @Excel(name = "帽子图片")
    private String hatsImage;

    /** 帽子类型 */
    @Excel(name = "帽子类型")
    private String hatsType;

    public void setHatsId(Long hatsId) 
    {
        this.hatsId = hatsId;
    }

    public Long getHatsId() 
    {
        return hatsId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setHatsName(String hatsName) 
    {
        this.hatsName = hatsName;
    }

    public String getHatsName() 
    {
        return hatsName;
    }
    public void setHatsImage(String hatsImage) 
    {
        this.hatsImage = hatsImage;
    }

    public String getHatsImage() 
    {
        return hatsImage;
    }
    public void setHatsType(String hatsType) 
    {
        this.hatsType = hatsType;
    }

    public String getHatsType() 
    {
        return hatsType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hatsId", getHatsId())
            .append("usersId", getUsersId())
            .append("hatsName", getHatsName())
            .append("hatsImage", getHatsImage())
            .append("hatsType", getHatsType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
