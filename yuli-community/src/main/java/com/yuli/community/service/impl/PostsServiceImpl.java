package com.yuli.community.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuli.community.mapper.PostsMapper;
import com.yuli.community.domain.Posts;
import com.yuli.community.service.IPostsService;

/**
 * 帖子管理Service业务层处理
 * 
 * @author lz
 * @date 2024-04-27
 */
@Service("postsService")
public class PostsServiceImpl implements IPostsService 
{
    @Autowired
    private PostsMapper postsMapper;

    /**
     * 查询帖子管理
     * 
     * @param postsId 帖子管理主键
     * @return 帖子管理
     */
    @Override
    public Posts selectPostsByPostsId(Long postsId)
    {
        return postsMapper.selectPostsByPostsId(postsId);
    }

    /**
     * 查询帖子管理列表
     * 
     * @param posts 帖子管理
     * @return 帖子管理
     */
    @Override
    public List<Posts> selectPostsList(Posts posts)
    {
        return postsMapper.selectPostsList(posts);
    }

    /**
     * 新增帖子管理
     * 
     * @param posts 帖子管理
     * @return 结果
     */
    @Override
    public int insertPosts(Posts posts)
    {
        posts.setCreateTime(DateUtils.getNowDate());
        return postsMapper.insertPosts(posts);
    }

    /**
     * 修改帖子管理
     * 
     * @param posts 帖子管理
     * @return 结果
     */
    @Override
    public int updatePosts(Posts posts)
    {
        posts.setUpdateTime(DateUtils.getNowDate());
        return postsMapper.updatePosts(posts);
    }

    /**
     * 批量删除帖子管理
     * 
     * @param postsIds 需要删除的帖子管理主键
     * @return 结果
     */
    @Override
    public int deletePostsByPostsIds(Long[] postsIds)
    {
        return postsMapper.deletePostsByPostsIds(postsIds);
    }

    /**
     * 删除帖子管理信息
     * 
     * @param postsId 帖子管理主键
     * @return 结果
     */
    @Override
    public int deletePostsByPostsId(Long postsId)
    {
        return postsMapper.deletePostsByPostsId(postsId);
    }

    @Override
    public List<Posts> findAll() {
     List<Posts> posts=postsMapper.findAll();
        System.out.println(posts);
        return posts;
    }

    @Override
    public List<Posts> selectPostsListByUserId(String users_id) {
        return postsMapper.selectPostsListByUserId(users_id);
    }

    @Override
    public int updatePostsByUserId(Posts posts) {
        return postsMapper.updatePostsByUserId(posts);
    }
}
