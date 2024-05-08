package com.yuli.clothes.service;

import java.util.List;

import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.domain.Pants;

/**
 * 裤子管理Service接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface IPantsService 
{
    /**
     * 查询裤子管理
     * 
     * @param pantsId 裤子管理主键
     * @return 裤子管理
     */
    public Pants selectPantsByPantsId(Long pantsId);

    /**
     * 查询裤子管理列表
     * 
     * @param pants 裤子管理
     * @return 裤子管理集合
     */
    public List<Pants> selectPantsList(Pants pants);

    /**
     * 新增裤子管理
     * 
     * @param pants 裤子管理
     * @return 结果
     */
    public int insertPants(Pants pants);

    /**
     * 修改裤子管理
     * 
     * @param pants 裤子管理
     * @return 结果
     */
    public int updatePants(Pants pants);

    /**
     * 批量删除裤子管理
     * 
     * @param pantsIds 需要删除的裤子管理主键集合
     * @return 结果
     */
    public int deletePantsByPantsIds(Long[] pantsIds);

    /**
     * 删除裤子管理信息
     * 
     * @param pantsId 裤子管理主键
     * @return 结果
     */
    public int deletePantsByPantsId(Long pantsId);

    List<Pants> findByUsersId(String users_id);

    int updatePantsByUserId(Pants pants);
}
