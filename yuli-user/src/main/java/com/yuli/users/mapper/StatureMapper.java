package com.yuli.users.mapper;

import java.util.List;
import com.yuli.users.domain.Stature;

/**
 * 身材管理Mapper接口
 * 
 * @author lz
 * @date 2024-04-27
 */

public interface StatureMapper 
{
    /**
     * 查询身材管理
     * 
     * @param statureId 身材管理主键
     * @return 身材管理
     */
    public Stature selectStatureByStatureId(Long statureId);

    /**
     * 查询身材管理列表
     * 
     * @param stature 身材管理
     * @return 身材管理集合
     */
    public List<Stature> selectStatureList(Stature stature);

    /**
     * 新增身材管理
     * 
     * @param stature 身材管理
     * @return 结果
     */
    public int insertStature(Stature stature);

    /**
     * 修改身材管理
     * 
     * @param stature 身材管理
     * @return 结果
     */
    public int updateStature(Stature stature);

    /**
     * 删除身材管理
     * 
     * @param statureId 身材管理主键
     * @return 结果
     */
    public int deleteStatureByStatureId(Long statureId);

    /**
     * 批量删除身材管理
     * 
     * @param statureIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStatureByStatureIds(Long[] statureIds);
}
