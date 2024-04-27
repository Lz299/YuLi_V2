package com.yuli.clothes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.clothes.mapper.OutfitsMapper;
import com.yuli.clothes.domain.Outfits;
import com.yuli.clothes.service.IOutfitsService;

/**
 * 搭配管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("outfitsService")
public class OutfitsServiceImpl implements IOutfitsService 
{
    @Autowired
    private OutfitsMapper outfitsMapper;

    /**
     * 查询搭配管理
     * 
     * @param outfitsId 搭配管理主键
     * @return 搭配管理
     */
    @Override
    public Outfits selectOutfitsByOutfitsId(Long outfitsId)
    {
        return outfitsMapper.selectOutfitsByOutfitsId(outfitsId);
    }

    /**
     * 查询搭配管理列表
     * 
     * @param outfits 搭配管理
     * @return 搭配管理
     */
    @Override
    public List<Outfits> selectOutfitsList(Outfits outfits)
    {
        return outfitsMapper.selectOutfitsList(outfits);
    }

    /**
     * 新增搭配管理
     * 
     * @param outfits 搭配管理
     * @return 结果
     */
    @Override
    public int insertOutfits(Outfits outfits)
    {
        outfits.setCreateTime(DateUtils.getNowDate());
        return outfitsMapper.insertOutfits(outfits);
    }

    /**
     * 修改搭配管理
     * 
     * @param outfits 搭配管理
     * @return 结果
     */
    @Override
    public int updateOutfits(Outfits outfits)
    {
        outfits.setUpdateTime(DateUtils.getNowDate());
        return outfitsMapper.updateOutfits(outfits);
    }

    /**
     * 批量删除搭配管理
     * 
     * @param outfitsIds 需要删除的搭配管理主键
     * @return 结果
     */
    @Override
    public int deleteOutfitsByOutfitsIds(Long[] outfitsIds)
    {
        return outfitsMapper.deleteOutfitsByOutfitsIds(outfitsIds);
    }

    /**
     * 删除搭配管理信息
     * 
     * @param outfitsId 搭配管理主键
     * @return 结果
     */
    @Override
    public int deleteOutfitsByOutfitsId(Long outfitsId)
    {
        return outfitsMapper.deleteOutfitsByOutfitsId(outfitsId);
    }
}
