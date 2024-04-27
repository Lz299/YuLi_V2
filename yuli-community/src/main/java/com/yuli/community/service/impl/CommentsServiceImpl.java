package com.yuli.community.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.community.mapper.CommentsMapper;
import com.yuli.community.domain.Comments;
import com.yuli.community.service.ICommentsService;

/**
 * 评论管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("commentsService")
public class CommentsServiceImpl implements ICommentsService 
{
    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 查询评论管理
     * 
     * @param commentsId 评论管理主键
     * @return 评论管理
     */
    @Override
    public Comments selectCommentsByCommentsId(Long commentsId)
    {
        return commentsMapper.selectCommentsByCommentsId(commentsId);
    }

    /**
     * 查询评论管理列表
     * 
     * @param comments 评论管理
     * @return 评论管理
     */
    @Override
    public List<Comments> selectCommentsList(Comments comments)
    {
        return commentsMapper.selectCommentsList(comments);
    }

    /**
     * 新增评论管理
     * 
     * @param comments 评论管理
     * @return 结果
     */
    @Override
    public int insertComments(Comments comments)
    {
        comments.setCreateTime(DateUtils.getNowDate());
        return commentsMapper.insertComments(comments);
    }

    /**
     * 修改评论管理
     * 
     * @param comments 评论管理
     * @return 结果
     */
    @Override
    public int updateComments(Comments comments)
    {
        comments.setUpdateTime(DateUtils.getNowDate());
        return commentsMapper.updateComments(comments);
    }

    /**
     * 批量删除评论管理
     * 
     * @param commentsIds 需要删除的评论管理主键
     * @return 结果
     */
    @Override
    public int deleteCommentsByCommentsIds(Long[] commentsIds)
    {
        return commentsMapper.deleteCommentsByCommentsIds(commentsIds);
    }

    /**
     * 删除评论管理信息
     * 
     * @param commentsId 评论管理主键
     * @return 结果
     */
    @Override
    public int deleteCommentsByCommentsId(Long commentsId)
    {
        return commentsMapper.deleteCommentsByCommentsId(commentsId);
    }
}
