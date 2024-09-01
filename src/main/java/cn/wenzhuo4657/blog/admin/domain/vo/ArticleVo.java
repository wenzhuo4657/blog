package cn.wenzhuo4657.blog.admin.domain.vo;

/**
 * @className: ArticleVo
 * @author: wenzhuo4657
 * @date: 2024/9/1 11:26
 * @Version: 1.0
 * @description:
 */
public class ArticleVo {
    String title;
    String summary;

    public ArticleVo(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }

    public ArticleVo() {
    }

    @Override
    public String toString() {
        return "ArticleVo{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
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
}