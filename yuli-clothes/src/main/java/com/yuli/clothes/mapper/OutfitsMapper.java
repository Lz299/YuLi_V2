package com.yuli.clothes.mapper;

import java.util.List;

import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.domain.Outfits;

/**
 * 搭配管理Mapper接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface OutfitsMapper 
{
    /**
     * 查询搭配管理
     * 
     * @param outfitsId 搭配管理主键
     * @return 搭配管理
     */
    public Outfits selectOutfitsByOutfitsId(Long outfitsId);

    /**
     * 查询搭配管理列表
     * 
     * @param outfits 搭配管理
     * @return 搭配管理集合
     */
    public List<Outfits> selectOutfitsList(Outfits outfits);

    /**
     * 新增搭配管理
     * 
     * @param outfits 搭配管理
     * @return 结果
     */
    public int insertOutfits(Outfits outfits);

    /**
     * 修改搭配管理
     * 
     * @param outfits 搭配管理
     * @return 结果
     */
    public int updateOutfits(Outfits outfits);

    /**
     * 删除搭配管理
     * 
     * @param outfitsId 搭配管理主键
     * @return 结果
     */
    public int deleteOutfitsByOutfitsId(Long outfitsId);

    /**
     * 批量删除搭配管理
     * 
     * @param outfitsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOutfitsByOutfitsIds(Long[] outfitsIds);

    List<Outfits> findByUsersId(String users_id);

    int updateOutfitsByUserId(Outfits outfits);
}
