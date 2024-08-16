package cn.wenzhuo4657.blog.basic.domain.vo;

import java.util.Date;
import java.util.List;

/**
 * @className: CommentVo
 * @author: wenzhuo4657
 * @date: 2024/8/16 10:01
 * @Version: 1.0
 * @description:
 */
public class CommentVo {
    private Long id;

    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //发根评论的userid
    private Long toCommentUserId;
    //发根评论的userName
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;
    //当前评论的创建人id
    private Long createBy;

    private Date createTime;

    //评论是谁发的
    private String username;


    private List<CommentVo> children;

    @Override
    public String toString() {
        return "CommentVo{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", rootId=" + rootId +
                ", content='" + content + '\'' +
                ", toCommentUserId=" + toCommentUserId +
                ", toCommentUserName='" + toCommentUserName + '\'' +
                ", toCommentId=" + toCommentId +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", username='" + username + '\'' +
                ", children=" + children +
                '}';
    }

    public CommentVo() {

    }

    public CommentVo(Long id, Long articleId, Long rootId, String content, Long toCommentUserId, String toCommentUserName, Long toCommentId, Long createBy, Date createTime, String username, List<CommentVo> children) {
        this.id = id;
        this.articleId = articleId;
        this.rootId = rootId;
        this.content = content;
        this.toCommentUserId = toCommentUserId;
        this.toCommentUserName = toCommentUserName;
        this.toCommentId = toCommentId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.username = username;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getToCommentUserName() {
        return toCommentUserName;
    }

    public void setToCommentUserName(String toCommentUserName) {
        this.toCommentUserName = toCommentUserName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CommentVo> getChildren() {
        return children;
    }

    public void setChildren(List<CommentVo> children) {
        this.children = children;
    }
}