package com.yuli.clothes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.clothes.mapper.OrnamentMapper;
import com.yuli.clothes.domain.Ornament;
import com.yuli.clothes.service.IOrnamentService;

/**
 * 装饰管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("ornamentService")
public class OrnamentServiceImpl implements IOrnamentService 
{
    @Autowired
    private OrnamentMapper ornamentMapper;

    /**
     * 查询装饰管理
     * 
     * @param ornamentId 装饰管理主键
     * @return 装饰管理
     */
    @Override
    public Ornament selectOrnamentByOrnamentId(Long ornamentId)
    {
        return ornamentMapper.selectOrnamentByOrnamentId(ornamentId);
    }

    /**
     * 查询装饰管理列表
     * 
     * @param ornament 装饰管理
     * @return 装饰管理
     */
    @Override
    public List<Ornament> selectOrnamentList(Ornament ornament)
    {
        return ornamentMapper.selectOrnamentList(ornament);
    }

    /**
     * 新增装饰管理
     * 
     * @param ornament 装饰管理
     * @return 结果
     */
    @Override
    public int insertOrnament(Ornament ornament)
    {
        ornament.setCreateTime(DateUtils.getNowDate());
        return ornamentMapper.insertOrnament(ornament);
    }

    /**
     * 修改装饰管理
     * 
     * @param ornament 装饰管理
     * @return 结果
     */
    @Override
    public int updateOrnament(Ornament ornament)
    {
        ornament.setUpdateTime(DateUtils.getNowDate());
        return ornamentMapper.updateOrnament(ornament);
    }

    /**
     * 批量删除装饰管理
     * 
     * @param ornamentIds 需要删除的装饰管理主键
     * @return 结果
     */
    @Override
    public int deleteOrnamentByOrnamentIds(Long[] ornamentIds)
    {
        return ornamentMapper.deleteOrnamentByOrnamentIds(ornamentIds);
    }

    /**
     * 删除装饰管理信息
     * 
     * @param ornamentId 装饰管理主键
     * @return 结果
     */
    @Override
    public int deleteOrnamentByOrnamentId(Long ornamentId)
    {
        return ornamentMapper.deleteOrnamentByOrnamentId(ornamentId);
    }
}
