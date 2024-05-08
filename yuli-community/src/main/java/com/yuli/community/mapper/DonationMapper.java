package com.yuli.community.mapper;

import java.util.List;
import com.yuli.community.domain.Donation;

/**
 * 捐赠管理Mapper接口
 * 
 * @author lz
 * @date 2024-05-08
 */
public interface DonationMapper 
{
    /**
     * 查询捐赠管理
     * 
     * @param donationId 捐赠管理主键
     * @return 捐赠管理
     */
    public Donation selectDonationByDonationId(Long donationId);

    /**
     * 查询捐赠管理列表
     * 
     * @param donation 捐赠管理
     * @return 捐赠管理集合
     */
    public List<Donation> selectDonationList(Donation donation);

    /**
     * 新增捐赠管理
     * 
     * @param donation 捐赠管理
     * @return 结果
     */
    public int insertDonation(Donation donation);

    /**
     * 修改捐赠管理
     * 
     * @param donation 捐赠管理
     * @return 结果
     */
    public int updateDonation(Donation donation);

    /**
     * 删除捐赠管理
     * 
     * @param donationId 捐赠管理主键
     * @return 结果
     */
    public int deleteDonationByDonationId(Long donationId);

    /**
     * 批量删除捐赠管理
     * 
     * @param donationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDonationByDonationIds(Long[] donationIds);
}
