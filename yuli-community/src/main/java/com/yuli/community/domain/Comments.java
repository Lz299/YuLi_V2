package com.yuli.community.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论管理对象 comments
 * 
 * @author lz
 * @date 2024-04-27
 */
public class Comments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论id */
    private Long commentsId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long usersId;

    /** 帖子id */
    @Excel(name = "帖子id")
    private Long postsId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String commentsContent;

    public void setCommentsId(Long commentsId) 
    {
        this.commentsId = commentsId;
    }

    public Long getCommentsId() 
    {
        return commentsId;
    }
    public void setUsersId(Long usersId) 
    {
        this.usersId = usersId;
    }

    public Long getUsersId() 
    {
        return usersId;
    }
    public void setPostsId(Long postsId) 
    {
        this.postsId = postsId;
    }

    public Long getPostsId() 
    {
        return postsId;
    }
    public void setCommentsContent(String commentsContent) 
    {
        this.commentsContent = commentsContent;
    }

    public String getCommentsContent() 
    {
        return commentsContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentsId", getCommentsId())
            .append("usersId", getUsersId())
            .append("postsId", getPostsId())
            .append("commentsContent", getCommentsContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
