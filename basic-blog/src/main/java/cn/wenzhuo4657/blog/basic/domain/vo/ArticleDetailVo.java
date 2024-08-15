package cn.wenzhuo4657.blog.basic.domain.vo;

import java.util.Date;

/**
 * @className: ArticleDetailVo
 * @author: wenzhuo4657
 * @date: 2024/8/15 10:42
 * @Version: 1.0
 * @description:
 */
public class ArticleDetailVo {
    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;

    //文章详情代码实现，新增了文章的分类id
    private Long categoryId;

    //文章详情代码实现，新增了文章的内容，也就是详情
    private String content;

    //缩略图
    private String thumbnail;
    //访问量
    private Long viewCount;

    private Date createTime;


    //所属分类名
    private String categoryName;


    @Override
    public String toString() {
        return "ArticleDetailVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", categoryId=" + categoryId +
                ", content='" + content + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", viewCount=" + viewCount +
                ", createTime=" + createTime +
                '}';
    }

    public ArticleDetailVo() {
    }

    public ArticleDetailVo(Long id, String title, String summary, Long categoryId, String content, String categoryName, String thumbnail, Long viewCount, Date createTime) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.categoryId = categoryId;
        this.content = content;
        this.categoryName = categoryName;
        this.thumbnail = thumbnail;
        this.viewCount = viewCount;
        this.createTime = createTime;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}