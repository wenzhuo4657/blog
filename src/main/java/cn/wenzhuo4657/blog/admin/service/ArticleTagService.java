package cn.wenzhuo4657.blog.admin.service;


import cn.wenzhuo4657.blog.admin.domain.enity.ArticleTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_article_tag(文章标签关联表)】的数据库操作Service
* @createDate 2024-09-01 09:21:18
*/
public interface ArticleTagService extends IService<ArticleTag> {

    void Relevancy(Long id, List<Long> tags);
}
