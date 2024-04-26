package com.yuli.clothes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * tops对象 tops
 * 
 * @author lz
 * @date 2024-04-26
 */
public class Tops extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 帽子id */
    private Long topsId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 帽子名字 */
    @Excel(name = "帽子名字")
    private String topsName;

    /** 帽子图片 */
    @Excel(name = "帽子图片")
    private String topsImage;

    /** 帽子类型 */
    @Excel(name = "帽子类型")
    private String topsType;

    public void setTopsId(Long topsId) 
    {
        this.topsId = topsId;
    }

    public Long getTopsId() 
    {
        return topsId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setTopsName(String topsName) 
    {
        this.topsName = topsName;
    }

    public String getTopsName() 
    {
        return topsName;
    }
    public void setTopsImage(String topsImage) 
    {
        this.topsImage = topsImage;
    }

    public String getTopsImage() 
    {
        return topsImage;
    }
    public void setTopsType(String topsType) 
    {
        this.topsType = topsType;
    }

    public String getTopsType() 
    {
        return topsType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("topsId", getTopsId())
            .append("usersId", getUsersId())
            .append("topsName", getTopsName())
            .append("topsImage", getTopsImage())
            .append("topsType", getTopsType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
