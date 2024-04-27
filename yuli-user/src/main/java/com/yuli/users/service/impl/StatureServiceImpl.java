package com.yuli.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.users.mapper.StatureMapper;
import com.yuli.users.domain.Stature;
import com.yuli.users.service.IStatureService;

/**
 * 身材管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("statureService")
public class StatureServiceImpl implements IStatureService 
{
    @Autowired
    private StatureMapper statureMapper;

    /**
     * 查询身材管理
     * 
     * @param statureId 身材管理主键
     * @return 身材管理
     */
    @Override
    public Stature selectStatureByStatureId(Long statureId)
    {
        return statureMapper.selectStatureByStatureId(statureId);
    }

    /**
     * 查询身材管理列表
     * 
     * @param stature 身材管理
     * @return 身材管理
     */
    @Override
    public List<Stature> selectStatureList(Stature stature)
    {
        return statureMapper.selectStatureList(stature);
    }

    /**
     * 新增身材管理
     * 
     * @param stature 身材管理
     * @return 结果
     */
    @Override
    public int insertStature(Stature stature)
    {
        stature.setCreateTime(DateUtils.getNowDate());
        return statureMapper.insertStature(stature);
    }

    /**
     * 修改身材管理
     * 
     * @param stature 身材管理
     * @return 结果
     */
    @Override
    public int updateStature(Stature stature)
    {
        stature.setUpdateTime(DateUtils.getNowDate());
        return statureMapper.updateStature(stature);
    }

    /**
     * 批量删除身材管理
     * 
     * @param statureIds 需要删除的身材管理主键
     * @return 结果
     */
    @Override
    public int deleteStatureByStatureIds(Long[] statureIds)
    {
        return statureMapper.deleteStatureByStatureIds(statureIds);
    }

    /**
     * 删除身材管理信息
     * 
     * @param statureId 身材管理主键
     * @return 结果
     */
    @Override
    public int deleteStatureByStatureId(Long statureId)
    {
        return statureMapper.deleteStatureByStatureId(statureId);
    }
}
