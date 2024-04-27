package com.yuli.clothes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 搭配管理对象 outfits
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Outfits extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 搭配id */
    private Long outfitsId;

    /** 帽子id */
    @Excel(name = "帽子id")
    private Long topsId;

    /** 上衣id */
    @Excel(name = "上衣id")
    private Long hatsId;

    /** 裤子id */
    @Excel(name = "裤子id")
    private Long pantsId;

    /** 鞋子id */
    @Excel(name = "鞋子id")
    private Long shoesId;

    /** 装饰id */
    @Excel(name = "装饰id")
    private Long ornamentId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 搭配名称 */
    @Excel(name = "搭配名称")
    private String outfitsName;

    /** 搭配图 */
    @Excel(name = "搭配图")
    private String outfitsImage;

    public void setOutfitsId(Long outfitsId) 
    {
        this.outfitsId = outfitsId;
    }

    public Long getOutfitsId() 
    {
        return outfitsId;
    }
    public void setTopsId(Long topsId) 
    {
        this.topsId = topsId;
    }

    public Long getTopsId() 
    {
        return topsId;
    }
    public void setHatsId(Long hatsId) 
    {
        this.hatsId = hatsId;
    }

    public Long getHatsId() 
    {
        return hatsId;
    }
    public void setPantsId(Long pantsId) 
    {
        this.pantsId = pantsId;
    }

    public Long getPantsId() 
    {
        return pantsId;
    }
    public void setShoesId(Long shoesId) 
    {
        this.shoesId = shoesId;
    }

    public Long getShoesId() 
    {
        return shoesId;
    }
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
    public void setOutfitsName(String outfitsName) 
    {
        this.outfitsName = outfitsName;
    }

    public String getOutfitsName() 
    {
        return outfitsName;
    }
    public void setOutfitsImage(String outfitsImage) 
    {
        this.outfitsImage = outfitsImage;
    }

    public String getOutfitsImage() 
    {
        return outfitsImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outfitsId", getOutfitsId())
            .append("topsId", getTopsId())
            .append("hatsId", getHatsId())
            .append("pantsId", getPantsId())
            .append("shoesId", getShoesId())
            .append("ornamentId", getOrnamentId())
            .append("usersId", getUsersId())
            .append("outfitsName", getOutfitsName())
            .append("outfitsImage", getOutfitsImage())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
