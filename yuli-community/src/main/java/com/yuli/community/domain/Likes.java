package com.yuli.community.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 点赞管理对象 likes
 *
 * @author lz
 * @date 2024-04-27
 */
public class Likes extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 点赞id
     */
    private Long likesId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long usersId;

    /**
     * 帖子id
     */
    @Excel(name = "帖子id")
    private Long postsId;

    public void setLikesId(Long likesId) {
        this.likesId = likesId;
    }

    public Long getLikesId() {
        return likesId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setPostsId(Long postsId) {
        this.postsId = postsId;
    }

    public Long getPostsId() {
        return postsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("likesId", getLikesId())
                .append("usersId", getUsersId())
                .append("postsId", getPostsId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
