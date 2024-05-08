package com.yuli.community.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 捐赠管理对象 donation
 * 
 * @author lz
 * @date 2024-05-08
 */
public class Donation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 捐赠id */
    private Long donationId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 捐赠衣服 */
    @Excel(name = "捐赠衣服")
    private String clothes;

    /** 送货地址 */
    @Excel(name = "送货地址")
    private String donationAddress;

    /** 用户地址 */
    @Excel(name = "用户地址")
    private String usersAddress;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookingTime;

    public void setDonationId(Long donationId) 
    {
        this.donationId = donationId;
    }

    public Long getDonationId() 
    {
        return donationId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setClothes(String clothes) 
    {
        this.clothes = clothes;
    }

    public String getClothes() 
    {
        return clothes;
    }
    public void setDonationAddress(String donationAddress) 
    {
        this.donationAddress = donationAddress;
    }

    public String getDonationAddress() 
    {
        return donationAddress;
    }
    public void setUsersAddress(String usersAddress) 
    {
        this.usersAddress = usersAddress;
    }

    public String getUsersAddress() 
    {
        return usersAddress;
    }
    public void setBookingTime(Date bookingTime) 
    {
        this.bookingTime = bookingTime;
    }

    public Date getBookingTime() 
    {
        return bookingTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("donationId", getDonationId())
            .append("usersId", getUsersId())
            .append("clothes", getClothes())
            .append("donationAddress", getDonationAddress())
            .append("usersAddress", getUsersAddress())
            .append("bookingTime", getBookingTime())
            .toString();
    }
}
