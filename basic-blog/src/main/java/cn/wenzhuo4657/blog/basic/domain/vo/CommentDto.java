package cn.wenzhuo4657.blog.basic.domain.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @className: CommentDto
 * @author: wenzhuo4657
 * @date: 2024/8/16 11:21
 * @Version: 1.0
 * @description:
 */
public class CommentDto {
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;

    //文章id
    private Long articleId;

    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", articleId=" + articleId +
                ", rootId=" + rootId +
                ", content='" + content + '\'' +
                ", toCommentUserId=" + toCommentUserId +
                ", toCommentId=" + toCommentId +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                '}';
    }

    public CommentDto() {
    }

    public CommentDto(Long id, String type, Long articleId, Long rootId, String content, Long toCommentUserId, Long toCommentId, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer delFlag) {
        this.id = id;
        this.type = type;
        this.articleId = articleId;
        this.rootId = rootId;
        this.content = content;
        this.toCommentUserId = toCommentUserId;
        this.toCommentId = toCommentId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getToCommentUserId() {
        return toCommentUserId;
    }

    public void setToCommentUserId(Long toCommentUserId) {
        this.toCommentUserId = toCommentUserId;
    }

    public Long getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}