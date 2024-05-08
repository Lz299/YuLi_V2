package com.yuli.clothes.service;

import java.util.List;

import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.domain.Outfits;

/**
 * 搭配管理Service接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface IOutfitsService 
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
     * 批量删除搭配管理
     * 
     * @param outfitsIds 需要删除的搭配管理主键集合
     * @return 结果
     */
    public int deleteOutfitsByOutfitsIds(Long[] outfitsIds);

    /**
     * 删除搭配管理信息
     * 
     * @param outfitsId 搭配管理主键
     * @return 结果
     */
    public int deleteOutfitsByOutfitsId(Long outfitsId);

    List<Outfits> findByUsersId(String users_id);

    int updateOutfitsByUserId(Outfits outfits);
}
