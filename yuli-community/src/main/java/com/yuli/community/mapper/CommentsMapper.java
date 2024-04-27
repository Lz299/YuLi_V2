package com.yuli.community.mapper;

import java.util.List;
import com.yuli.community.domain.Comments;

/**
 * 评论管理Mapper接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface CommentsMapper 
{
    /**
     * 查询评论管理
     * 
     * @param commentsId 评论管理主键
     * @return 评论管理
     */
    public Comments selectCommentsByCommentsId(Long commentsId);

    /**
     * 查询评论管理列表
     * 
     * @param comments 评论管理
     * @return 评论管理集合
     */
    public List<Comments> selectCommentsList(Comments comments);

    /**
     * 新增评论管理
     * 
     * @param comments 评论管理
     * @return 结果
     */
    public int insertComments(Comments comments);

    /**
     * 修改评论管理
     * 
     * @param comments 评论管理
     * @return 结果
     */
    public int updateComments(Comments comments);

    /**
     * 删除评论管理
     * 
     * @param commentsId 评论管理主键
     * @return 结果
     */
    public int deleteCommentsByCommentsId(Long commentsId);

    /**
     * 批量删除评论管理
     * 
     * @param commentsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommentsByCommentsIds(Long[] commentsIds);
}
