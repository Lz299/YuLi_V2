package com.yuli.clothes.mapper;

import java.util.List;

import com.yuli.clothes.domain.Hats;
import com.yuli.clothes.domain.Ornament;

/**
 * 装饰管理Mapper接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface OrnamentMapper 
{
    /**
     * 查询装饰管理
     * 
     * @param ornamentId 装饰管理主键
     * @return 装饰管理
     */
    public Ornament selectOrnamentByOrnamentId(Long ornamentId);

    /**
     * 查询装饰管理列表
     * 
     * @param ornament 装饰管理
     * @return 装饰管理集合
     */
    public List<Ornament> selectOrnamentList(Ornament ornament);

    /**
     * 新增装饰管理
     * 
     * @param ornament 装饰管理
     * @return 结果
     */
    public int insertOrnament(Ornament ornament);

    /**
     * 修改装饰管理
     * 
     * @param ornament 装饰管理
     * @return 结果
     */
    public int updateOrnament(Ornament ornament);

    /**
     * 删除装饰管理
     * 
     * @param ornamentId 装饰管理主键
     * @return 结果
     */
    public int deleteOrnamentByOrnamentId(Long ornamentId);

    /**
     * 批量删除装饰管理
     * 
     * @param ornamentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrnamentByOrnamentIds(Long[] ornamentIds);

    int updateOrnamentsByUserId(Ornament ornament);

    List<Ornament> findByUsersId(String users_id);
}
