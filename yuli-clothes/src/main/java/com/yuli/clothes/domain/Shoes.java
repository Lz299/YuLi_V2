package com.yuli.clothes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 鞋子管理对象 shoes
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Shoes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 鞋子id */
    private Long shoesId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 鞋子名称 */
    @Excel(name = "鞋子名称")
    private String shoesName;

    /** 鞋子图片 */
    @Excel(name = "鞋子图片")
    private String shoesImage;

    /** 鞋子类型 */
    @Excel(name = "鞋子类型")
    private String shoesType;

    public void setShoesId(Long shoesId) 
    {
        this.shoesId = shoesId;
    }

    public Long getShoesId() 
    {
        return shoesId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setShoesName(String shoesName) 
    {
        this.shoesName = shoesName;
    }

    public String getShoesName() 
    {
        return shoesName;
    }
    public void setShoesImage(String shoesImage) 
    {
        this.shoesImage = shoesImage;
    }

    public String getShoesImage() 
    {
        return shoesImage;
    }
    public void setShoesType(String shoesType) 
    {
        this.shoesType = shoesType;
    }

    public String getShoesType() 
    {
        return shoesType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shoesId", getShoesId())
            .append("usersId", getUsersId())
            .append("shoesName", getShoesName())
            .append("shoesImage", getShoesImage())
            .append("shoesType", getShoesType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
