package com.yuli.clothes.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.clothes.mapper.ShoesMapper;
import com.yuli.clothes.domain.Shoes;
import com.yuli.clothes.service.IShoesService;

/**
 * 鞋子管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("shoesService")
public class ShoesServiceImpl implements IShoesService 
{
    @Autowired
    private ShoesMapper shoesMapper;

    /**
     * 查询鞋子管理
     * 
     * @param shoesId 鞋子管理主键
     * @return 鞋子管理
     */
    @Override
    public Shoes selectShoesByShoesId(Long shoesId)
    {
        return shoesMapper.selectShoesByShoesId(shoesId);
    }

    /**
     * 查询鞋子管理列表
     * 
     * @param shoes 鞋子管理
     * @return 鞋子管理
     */
    @Override
    public List<Shoes> selectShoesList(Shoes shoes)
    {
        return shoesMapper.selectShoesList(shoes);
    }

    /**
     * 新增鞋子管理
     * 
     * @param shoes 鞋子管理
     * @return 结果
     */
    @Override
    public int insertShoes(Shoes shoes)
    {
        shoes.setCreateTime(DateUtils.getNowDate());
        return shoesMapper.insertShoes(shoes);
    }

    /**
     * 修改鞋子管理
     * 
     * @param shoes 鞋子管理
     * @return 结果
     */
    @Override
    public int updateShoes(Shoes shoes)
    {
        shoes.setUpdateTime(DateUtils.getNowDate());
        return shoesMapper.updateShoes(shoes);
    }

    /**
     * 批量删除鞋子管理
     * 
     * @param shoesIds 需要删除的鞋子管理主键
     * @return 结果
     */
    @Override
    public int deleteShoesByShoesIds(Long[] shoesIds)
    {
        return shoesMapper.deleteShoesByShoesIds(shoesIds);
    }

    /**
     * 删除鞋子管理信息
     * 
     * @param shoesId 鞋子管理主键
     * @return 结果
     */
    @Override
    public int deleteShoesByShoesId(Long shoesId)
    {
        return shoesMapper.deleteShoesByShoesId(shoesId);
    }

    @Override
    public List<Shoes> findByUsersId(String users_id) {
        return shoesMapper.findByUsersId(users_id);
    }

    @Override
    public int updateShoesByUserId(Shoes shoes) {
        return shoesMapper.updateShoesByUserId(shoes);
    }
}
