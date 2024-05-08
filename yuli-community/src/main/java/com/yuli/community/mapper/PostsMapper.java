package com.yuli.community.mapper;

import java.util.List;
import com.yuli.community.domain.Posts;

/**
 * 帖子管理Mapper接口
 * 
 * @author lz
 * @date 2024-04-27
 */
public interface PostsMapper 
{
    /**
     * 查询帖子管理
     * 
     * @param postsId 帖子管理主键
     * @return 帖子管理
     */
    public Posts selectPostsByPostsId(Long postsId);

    /**
     * 查询帖子管理列表
     * 
     * @param posts 帖子管理
     * @return 帖子管理集合
     */
    public List<Posts> selectPostsList(Posts posts);

    /**
     * 新增帖子管理
     * 
     * @param posts 帖子管理
     * @return 结果
     */
    public int insertPosts(Posts posts);

    /**
     * 修改帖子管理
     * 
     * @param posts 帖子管理
     * @return 结果
     */
    public int updatePosts(Posts posts);

    /**
     * 删除帖子管理
     * 
     * @param postsId 帖子管理主键
     * @return 结果
     */
    public int deletePostsByPostsId(Long postsId);

    /**
     * 批量删除帖子管理
     * 
     * @param postsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePostsByPostsIds(Long[] postsIds);

    List<Posts> findAll();
}
