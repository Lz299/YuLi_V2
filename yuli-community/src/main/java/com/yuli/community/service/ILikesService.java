package com.yuli.community.service;

import java.util.List;
import com.yuli.community.domain.Likes;

/**
 * 点赞管理Service接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface ILikesService 
{
    /**
     * 查询点赞管理
     * 
     * @param likesId 点赞管理主键
     * @return 点赞管理
     */
    public Likes selectLikesByLikesId(Long likesId);

    /**
     * 查询点赞管理列表
     * 
     * @param likes 点赞管理
     * @return 点赞管理集合
     */
    public List<Likes> selectLikesList(Likes likes);

    /**
     * 新增点赞管理
     * 
     * @param likes 点赞管理
     * @return 结果
     */
    public int insertLikes(Likes likes);

    /**
     * 修改点赞管理
     * 
     * @param likes 点赞管理
     * @return 结果
     */
    public int updateLikes(Likes likes);

    /**
     * 批量删除点赞管理
     * 
     * @param likesIds 需要删除的点赞管理主键集合
     * @return 结果
     */
    public int deleteLikesByLikesIds(Long[] likesIds);

    /**
     * 删除点赞管理信息
     * 
     * @param likesId 点赞管理主键
     * @return 结果
     */
    public int deleteLikesByLikesId(Long likesId);
}
