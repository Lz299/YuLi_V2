package com.yuli.community.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帖子管理对象 posts
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Posts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 帖子id */
    private Long postsId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 帖子标题 */
    @Excel(name = "帖子标题")
    private String postsTitle;

    /** 帖子图片 */
    @Excel(name = "帖子图片")
    private String postsImage;

    /** 帖子内容 */
    @Excel(name = "帖子内容")
    private String postsContent;

    public void setPostsId(Long postsId) 
    {
        this.postsId = postsId;
    }

    public Long getPostsId() 
    {
        return postsId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setPostsTitle(String postsTitle) 
    {
        this.postsTitle = postsTitle;
    }

    public String getPostsTitle() 
    {
        return postsTitle;
    }
    public void setPostsImage(String postsImage) 
    {
        this.postsImage = postsImage;
    }

    public String getPostsImage() 
    {
        return postsImage;
    }
    public void setPostsContent(String postsContent) 
    {
        this.postsContent = postsContent;
    }

    public String getPostsContent() 
    {
        return postsContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postsId", getPostsId())
            .append("usersId", getUsersId())
            .append("postsTitle", getPostsTitle())
            .append("postsImage", getPostsImage())
            .append("postsContent", getPostsContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
