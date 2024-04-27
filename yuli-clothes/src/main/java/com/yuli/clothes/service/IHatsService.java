package com.yuli.clothes.service;

import java.util.List;
import com.yuli.clothes.domain.Hats;

/**
 * 上衣管理Service接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface IHatsService 
{
    /**
     * 查询上衣管理
     * 
     * @param hatsId 上衣管理主键
     * @return 上衣管理
     */
    public Hats selectHatsByHatsId(Long hatsId);

    /**
     * 查询上衣管理列表
     * 
     * @param hats 上衣管理
     * @return 上衣管理集合
     */
    public List<Hats> selectHatsList(Hats hats);

    /**
     * 新增上衣管理
     * 
     * @param hats 上衣管理
     * @return 结果
     */
    public int insertHats(Hats hats);

    /**
     * 修改上衣管理
     * 
     * @param hats 上衣管理
     * @return 结果
     */
    public int updateHats(Hats hats);

    /**
     * 批量删除上衣管理
     * 
     * @param hatsIds 需要删除的上衣管理主键集合
     * @return 结果
     */
    public int deleteHatsByHatsIds(Long[] hatsIds);

    /**
     * 删除上衣管理信息
     * 
     * @param hatsId 上衣管理主键
     * @return 结果
     */
    public int deleteHatsByHatsId(Long hatsId);
}
