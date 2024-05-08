package com.yuli.clothes.service;

import java.util.List;

import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.domain.Tops;

/**
 * topsService接口
 * 
 * @author lz
 * @date 2024-04-26
 */
public interface ITopsService 
{
    /**
     * 查询tops
     * 
     * @param topsId tops主键
     * @return tops
     */
    public Tops selectTopsByTopsId(Long topsId);

    /**
     * 查询tops列表
     * 
     * @param tops tops
     * @return tops集合
     */
    public List<Tops> selectTopsList(Tops tops);

    /**
     * 新增tops
     * 
     * @param tops tops
     * @return 结果
     */
    public int insertTops(Tops tops);

    /**
     * 修改tops
     * 
     * @param tops tops
     * @return 结果
     */
    public int updateTops(Tops tops);

    /**
     * 批量删除tops
     * 
     * @param topsIds 需要删除的tops主键集合
     * @return 结果
     */
    public int deleteTopsByTopsIds(Long[] topsIds);

    /**
     * 删除tops信息
     * 
     * @param topsId tops主键
     * @return 结果
     */
    public int deleteTopsByTopsId(Long topsId);

    List<Tops> findTopsByUsersId(String users_id);

    int updateTopsByUserId(Tops tops);
}
