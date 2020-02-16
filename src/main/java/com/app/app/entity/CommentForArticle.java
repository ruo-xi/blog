package com.app.app.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class CommentForArticle {
    Integer id;
    Integer userId;
    Integer articleId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date createDate;
    Integer likeCounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Integer likeCounts) {
        this.likeCounts = likeCounts;
    }
}
