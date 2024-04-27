package com.yuli.clothes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 裤子管理对象 pants
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Pants extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 裤子id */
    private Long pantsId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 裤子名称 */
    @Excel(name = "裤子名称")
    private String pantsName;

    /** 裤子图片 */
    @Excel(name = "裤子图片")
    private String pantsImage;

    /** 裤子类型 */
    @Excel(name = "裤子类型")
    private String pantsType;

    public void setPantsId(Long pantsId) 
    {
        this.pantsId = pantsId;
    }

    public Long getPantsId() 
    {
        return pantsId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setPantsName(String pantsName) 
    {
        this.pantsName = pantsName;
    }

    public String getPantsName() 
    {
        return pantsName;
    }
    public void setPantsImage(String pantsImage) 
    {
        this.pantsImage = pantsImage;
    }

    public String getPantsImage() 
    {
        return pantsImage;
    }
    public void setPantsType(String pantsType) 
    {
        this.pantsType = pantsType;
    }

    public String getPantsType() 
    {
        return pantsType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pantsId", getPantsId())
            .append("usersId", getUsersId())
            .append("pantsName", getPantsName())
            .append("pantsImage", getPantsImage())
            .append("pantsType", getPantsType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
