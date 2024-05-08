package com.yuli.clothes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.yuli.clothes.domain.Hats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.clothes.mapper.TopsMapper;
import com.yuli.clothes.domain.Tops;
import com.yuli.clothes.service.ITopsService;

/**
 * topsService业务层处理
 * 
 * @author lz
 * @date 2024-04-26
 */
@Service("topsService")
public class TopsServiceImpl implements ITopsService 
{
    @Autowired
    private TopsMapper topsMapper;

    /**
     * 查询tops
     * 
     * @param topsId tops主键
     * @return tops
     */
    @Override
    public Tops selectTopsByTopsId(Long topsId)
    {
        return topsMapper.selectTopsByTopsId(topsId);
    }

    /**
     * 查询tops列表
     * 
     * @param tops tops
     * @return tops
     */
    @Override
    public List<Tops> selectTopsList(Tops tops)
    {
        return topsMapper.selectTopsList(tops);
    }

    /**
     * 新增tops
     * 
     * @param tops tops
     * @return 结果
     */
    @Override
    public int insertTops(Tops tops)
    {
        tops.setCreateTime(DateUtils.getNowDate());
        return topsMapper.insertTops(tops);
    }

    /**
     * 修改tops
     * 
     * @param tops tops
     * @return 结果
     */
    @Override
    public int updateTops(Tops tops)
    {
        tops.setUpdateTime(DateUtils.getNowDate());
        return topsMapper.updateTops(tops);
    }

    /**
     * 批量删除tops
     * 
     * @param topsIds 需要删除的tops主键
     * @return 结果
     */
    @Override
    public int deleteTopsByTopsIds(Long[] topsIds)
    {
        return topsMapper.deleteTopsByTopsIds(topsIds);
    }

    /**
     * 删除tops信息
     * 
     * @param topsId tops主键
     * @return 结果
     */
    @Override
    public int deleteTopsByTopsId(Long topsId)
    {
        return topsMapper.deleteTopsByTopsId(topsId);
    }

    @Override
    public List<Tops> findTopsByUsersId(String users_id) {
        return topsMapper.findByUsersId(users_id);
    }

    @Override
    public int updateTopsByUserId(Tops tops) {
        return topsMapper.updateTopsByUserId(tops);
    }
}
