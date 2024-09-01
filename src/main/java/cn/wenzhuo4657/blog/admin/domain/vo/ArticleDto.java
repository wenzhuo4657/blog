package cn.wenzhuo4657.blog.admin.domain.vo;

import java.util.List;

public class ArticleDto {

    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    //tags属性是一个List集合，用于接收文章关联标签的id
    private List<Long> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "AtricleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", categoryId=" + categoryId +
                ", thumbnail='" + thumbnail + '\'' +
                ", isTop='" + isTop + '\'' +
                ", status='" + status + '\'' +
                ", viewCount=" + viewCount +
                ", isComment='" + isComment + '\'' +
                ", tags=" + tags +
                '}';
    }

    public ArticleDto() {
    }

    public ArticleDto(Long id, String title, String content, String summary, Long categoryId, String thumbnail, String isTop, String status, Long viewCount, String isComment, List<Long> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.categoryId = categoryId;
        this.thumbnail = thumbnail;
        this.isTop = isTop;
        this.status = status;
        this.viewCount = viewCount;
        this.isComment = isComment;
        this.tags = tags;
    }
}