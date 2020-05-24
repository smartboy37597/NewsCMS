package com.smtboy.news.pojo;

import java.util.Date;

public class News {
    private Integer id;

    private Integer pId;

    private Integer userId;

    private String title;

    private String content;

    private Integer readCount;

    private String type;

    private Date createTime;

    private Date updateTime;

    public News(Integer id, Integer pId, Integer userId, String title, String content, Integer readCount, String type, Date createTime, Date updateTime) {
        this.id = id;
        this.pId = pId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.readCount = readCount;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public News() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}