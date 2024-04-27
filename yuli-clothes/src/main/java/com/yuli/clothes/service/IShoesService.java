package com.yuli.clothes.service;

import java.util.List;
import com.yuli.clothes.domain.Shoes;

/**
 * 鞋子管理Service接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface IShoesService 
{
    /**
     * 查询鞋子管理
     * 
     * @param shoesId 鞋子管理主键
     * @return 鞋子管理
     */
    public Shoes selectShoesByShoesId(Long shoesId);

    /**
     * 查询鞋子管理列表
     * 
     * @param shoes 鞋子管理
     * @return 鞋子管理集合
     */
    public List<Shoes> selectShoesList(Shoes shoes);

    /**
     * 新增鞋子管理
     * 
     * @param shoes 鞋子管理
     * @return 结果
     */
    public int insertShoes(Shoes shoes);

    /**
     * 修改鞋子管理
     * 
     * @param shoes 鞋子管理
     * @return 结果
     */
    public int updateShoes(Shoes shoes);

    /**
     * 批量删除鞋子管理
     * 
     * @param shoesIds 需要删除的鞋子管理主键集合
     * @return 结果
     */
    public int deleteShoesByShoesIds(Long[] shoesIds);

    /**
     * 删除鞋子管理信息
     * 
     * @param shoesId 鞋子管理主键
     * @return 结果
     */
    public int deleteShoesByShoesId(Long shoesId);
}
