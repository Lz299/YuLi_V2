package com.yuli.users.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 身材管理对象 stature
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Stature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 身材id */
    private Long statureId;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 身高 */
    @Excel(name = "身高")
    private Long height;

    /** 体重  */
    @Excel(name = "体重 ")
    private Long weight;

    /** 腰围 */
    @Excel(name = "腰围")
    private Long waistline;

    /** 胸围 */
    @Excel(name = "胸围")
    private Long bust;

    /** 臀围 */
    @Excel(name = "臀围")
    private Long hips;

    /** 肩宽 */
    @Excel(name = "肩宽")
    private Long shoulderWidth;

    /** 臂长 */
    @Excel(name = "臂长")
    private Long armLength;

    /** 腿长 */
    @Excel(name = "腿长")
    private Long legLength;

    /** 身材比 */
    @Excel(name = "身材比")
    private String bodyProportions;

    /** 体型 */
    @Excel(name = "体型")
    private String somatotype;

    /** 肤色 */
    @Excel(name = "肤色")
    private String complexion;

    /** 穿着习惯 */
    @Excel(name = "穿着习惯")
    private String dressHabits;

    /** 特殊需求 */
    @Excel(name = "特殊需求")
    private String specialNeeds;

    public void setStatureId(Long statureId) 
    {
        this.statureId = statureId;
    }

    public Long getStatureId() 
    {
        return statureId;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setWaistline(Long waistline) 
    {
        this.waistline = waistline;
    }

    public Long getWaistline() 
    {
        return waistline;
    }
    public void setBust(Long bust) 
    {
        this.bust = bust;
    }

    public Long getBust() 
    {
        return bust;
    }
    public void setHips(Long hips) 
    {
        this.hips = hips;
    }

    public Long getHips() 
    {
        return hips;
    }
    public void setShoulderWidth(Long shoulderWidth) 
    {
        this.shoulderWidth = shoulderWidth;
    }

    public Long getShoulderWidth() 
    {
        return shoulderWidth;
    }
    public void setArmLength(Long armLength) 
    {
        this.armLength = armLength;
    }

    public Long getArmLength() 
    {
        return armLength;
    }
    public void setLegLength(Long legLength) 
    {
        this.legLength = legLength;
    }

    public Long getLegLength() 
    {
        return legLength;
    }
    public void setBodyProportions(String bodyProportions) 
    {
        this.bodyProportions = bodyProportions;
    }

    public String getBodyProportions() 
    {
        return bodyProportions;
    }
    public void setSomatotype(String somatotype) 
    {
        this.somatotype = somatotype;
    }

    public String getSomatotype() 
    {
        return somatotype;
    }
    public void setComplexion(String complexion) 
    {
        this.complexion = complexion;
    }

    public String getComplexion() 
    {
        return complexion;
    }
    public void setDressHabits(String dressHabits) 
    {
        this.dressHabits = dressHabits;
    }

    public String getDressHabits() 
    {
        return dressHabits;
    }
    public void setSpecialNeeds(String specialNeeds) 
    {
        this.specialNeeds = specialNeeds;
    }

    public String getSpecialNeeds() 
    {
        return specialNeeds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("statureId", getStatureId())
            .append("age", getAge())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("waistline", getWaistline())
            .append("bust", getBust())
            .append("hips", getHips())
            .append("shoulderWidth", getShoulderWidth())
            .append("armLength", getArmLength())
            .append("legLength", getLegLength())
            .append("bodyProportions", getBodyProportions())
            .append("somatotype", getSomatotype())
            .append("complexion", getComplexion())
            .append("dressHabits", getDressHabits())
            .append("specialNeeds", getSpecialNeeds())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
