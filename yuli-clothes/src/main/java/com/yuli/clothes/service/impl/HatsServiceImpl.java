package com.yuli.clothes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.service.IHatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.clothes.mapper.HatsMapper;



/**
 * 上衣管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("hatsService")
public class HatsServiceImpl implements IHatsService
{
    @Autowired
    private HatsMapper hatsMapper;

    /**
     * 查询上衣管理
     * 
     * @param hatsId 上衣管理主键
     * @return 上衣管理
     */
    @Override
    public Hats selectHatsByHatsId(Long hatsId)
    {
        return hatsMapper.selectHatsByHatsId(hatsId);
    }

    /**
     * 查询上衣管理列表
     * 
     * @param hats 上衣管理
     * @return 上衣管理
     */
    @Override
    public List<Hats> selectHatsList(Hats hats)
    {
        return hatsMapper.selectHatsList(hats);
    }

    /**
     * 新增上衣管理
     * 
     * @param hats 上衣管理
     * @return 结果
     */
    @Override
    public int insertHats(Hats hats)
    {
        hats.setCreateTime(DateUtils.getNowDate());
        return hatsMapper.insertHats(hats);
    }

    /**
     * 修改上衣管理
     * 
     * @param hats 上衣管理
     * @return 结果
     */
    @Override
    public int updateHats(Hats hats)
    {
        hats.setUpdateTime(DateUtils.getNowDate());
        return hatsMapper.updateHats(hats);
    }

    /**
     * 批量删除上衣管理
     * 
     * @param hatsIds 需要删除的上衣管理主键
     * @return 结果
     */
    @Override
    public int deleteHatsByHatsIds(Long[] hatsIds)
    {
        return hatsMapper.deleteHatsByHatsIds(hatsIds);
    }

    /**
     * 删除上衣管理信息
     * 
     * @param hatsId 上衣管理主键
     * @return 结果
     */
    @Override
    public int deleteHatsByHatsId(Long hatsId)
    {
        return hatsMapper.deleteHatsByHatsId(hatsId);
    }
}
