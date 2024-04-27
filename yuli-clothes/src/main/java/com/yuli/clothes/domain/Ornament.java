package com.yuli.clothes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装饰管理对象 ornament
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Ornament extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 装饰id */
    private Long ornamentId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 装饰名称 */
    @Excel(name = "装饰名称")
    private String ornamentName;

    /** 装饰图片 */
    @Excel(name = "装饰图片")
    private Long ornamentImage;

    /** 装饰类型 */
    @Excel(name = "装饰类型")
    private String ornamentType;

    public void setOrnamentId(Long ornamentId) 
    {
        this.ornamentId = ornamentId;
    }

    public Long getOrnamentId() 
    {
        return ornamentId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setOrnamentName(String ornamentName) 
    {
        this.ornamentName = ornamentName;
    }

    public String getOrnamentName() 
    {
        return ornamentName;
    }
    public void setOrnamentImage(Long ornamentImage) 
    {
        this.ornamentImage = ornamentImage;
    }

    public Long getOrnamentImage() 
    {
        return ornamentImage;
    }
    public void setOrnamentType(String ornamentType) 
    {
        this.ornamentType = ornamentType;
    }

    public String getOrnamentType() 
    {
        return ornamentType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ornamentId", getOrnamentId())
            .append("usersId", getUsersId())
            .append("ornamentName", getOrnamentName())
            .append("ornamentImage", getOrnamentImage())
            .append("ornamentType", getOrnamentType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
