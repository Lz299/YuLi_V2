package com.yuli.community.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.community.mapper.DonationMapper;
import com.yuli.community.domain.Donation;
import com.yuli.community.service.IDonationService;

/**
 * 捐赠管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("donationService")
public class DonationServiceImpl implements IDonationService 
{
    @Autowired
    private DonationMapper donationMapper;

    /**
     * 查询捐赠管理
     * 
     * @param donationId 捐赠管理主键
     * @return 捐赠管理
     */
    @Override
    public Donation selectDonationByDonationId(Long donationId)
    {
        return donationMapper.selectDonationByDonationId(donationId);
    }

    /**
     * 查询捐赠管理列表
     * 
     * @param donation 捐赠管理
     * @return 捐赠管理
     */
    @Override
    public List<Donation> selectDonationList(Donation donation)
    {
        return donationMapper.selectDonationList(donation);
    }

    /**
     * 新增捐赠管理
     * 
     * @param donation 捐赠管理
     * @return 结果
     */
    @Override
    public int insertDonation(Donation donation)
    {
        return donationMapper.insertDonation(donation);
    }

    /**
     * 修改捐赠管理
     * 
     * @param donation 捐赠管理
     * @return 结果
     */
    @Override
    public int updateDonation(Donation donation)
    {
        return donationMapper.updateDonation(donation);
    }

    /**
     * 批量删除捐赠管理
     * 
     * @param donationIds 需要删除的捐赠管理主键
     * @return 结果
     */
    @Override
    public int deleteDonationByDonationIds(Long[] donationIds)
    {
        return donationMapper.deleteDonationByDonationIds(donationIds);
    }

    /**
     * 删除捐赠管理信息
     * 
     * @param donationId 捐赠管理主键
     * @return 结果
     */
    @Override
    public int deleteDonationByDonationId(Long donationId)
    {
        return donationMapper.deleteDonationByDonationId(donationId);
    }
}
