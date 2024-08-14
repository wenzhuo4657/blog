package cn.wenzhuo4657.blog.basic.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: HotArtcleVo
 * @author: wenzhuo4657
 * @date: 2024/8/14 10:21
 * @Version: 1.0
 * @description:
 */

@NoArgsConstructor
@AllArgsConstructor
public class HotArtcleVo {
    private  Long id;
    private  String title;
    private  Long viewCount;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "HotArtcleVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}