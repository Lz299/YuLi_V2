package com.yuli.community.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.community.mapper.LikesMapper;
import com.yuli.community.domain.Likes;
import com.yuli.community.service.ILikesService;

/**
 * 点赞管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("likesService")
public class LikesServiceImpl implements ILikesService 
{
    @Autowired
    private LikesMapper likesMapper;

    /**
     * 查询点赞管理
     * 
     * @param likesId 点赞管理主键
     * @return 点赞管理
     */
    @Override
    public Likes selectLikesByLikesId(Long likesId)
    {
        return likesMapper.selectLikesByLikesId(likesId);
    }

    /**
     * 查询点赞管理列表
     * 
     * @param likes 点赞管理
     * @return 点赞管理
     */
    @Override
    public List<Likes> selectLikesList(Likes likes)
    {
        return likesMapper.selectLikesList(likes);
    }

    /**
     * 新增点赞管理
     * 
     * @param likes 点赞管理
     * @return 结果
     */
    @Override
    public int insertLikes(Likes likes)
    {
        likes.setCreateTime(DateUtils.getNowDate());
        return likesMapper.insertLikes(likes);
    }

    /**
     * 修改点赞管理
     * 
     * @param likes 点赞管理
     * @return 结果
     */
    @Override
    public int updateLikes(Likes likes)
    {
        likes.setUpdateTime(DateUtils.getNowDate());
        return likesMapper.updateLikes(likes);
    }

    /**
     * 批量删除点赞管理
     * 
     * @param likesIds 需要删除的点赞管理主键
     * @return 结果
     */
    @Override
    public int deleteLikesByLikesIds(Long[] likesIds)
    {
        return likesMapper.deleteLikesByLikesIds(likesIds);
    }

    /**
     * 删除点赞管理信息
     * 
     * @param likesId 点赞管理主键
     * @return 结果
     */
    @Override
    public int deleteLikesByLikesId(Long likesId)
    {
        return likesMapper.deleteLikesByLikesId(likesId);
    }
}
