package com.yuli.clothes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.clothes.mapper.PantsMapper;
import com.yuli.clothes.domain.Pants;
import com.yuli.clothes.service.IPantsService;

/**
 * 裤子管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("pantsService")
public class PantsServiceImpl implements IPantsService 
{
    @Autowired
    private PantsMapper pantsMapper;

    /**
     * 查询裤子管理
     * 
     * @param pantsId 裤子管理主键
     * @return 裤子管理
     */
    @Override
    public Pants selectPantsByPantsId(Long pantsId)
    {
        return pantsMapper.selectPantsByPantsId(pantsId);
    }

    /**
     * 查询裤子管理列表
     * 
     * @param pants 裤子管理
     * @return 裤子管理
     */
    @Override
    public List<Pants> selectPantsList(Pants pants)
    {
        return pantsMapper.selectPantsList(pants);
    }

    /**
     * 新增裤子管理
     * 
     * @param pants 裤子管理
     * @return 结果
     */
    @Override
    public int insertPants(Pants pants)
    {
        pants.setCreateTime(DateUtils.getNowDate());
        return pantsMapper.insertPants(pants);
    }

    /**
     * 修改裤子管理
     * 
     * @param pants 裤子管理
     * @return 结果
     */
    @Override
    public int updatePants(Pants pants)
    {
        pants.setUpdateTime(DateUtils.getNowDate());
        return pantsMapper.updatePants(pants);
    }

    /**
     * 批量删除裤子管理
     * 
     * @param pantsIds 需要删除的裤子管理主键
     * @return 结果
     */
    @Override
    public int deletePantsByPantsIds(Long[] pantsIds)
    {
        return pantsMapper.deletePantsByPantsIds(pantsIds);
    }

    /**
     * 删除裤子管理信息
     * 
     * @param pantsId 裤子管理主键
     * @return 结果
     */
    @Override
    public int deletePantsByPantsId(Long pantsId)
    {
        return pantsMapper.deletePantsByPantsId(pantsId);
    }
}
