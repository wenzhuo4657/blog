package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.dao.ArticleTagMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.ArticleTag;
import cn.wenzhuo4657.blog.admin.service.ArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86147
 * @description 针对表【sg_article_tag(文章标签关联表)】的数据库操作Service实现
 * @createDate 2024-09-01 09:21:18
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag>
        implements ArticleTagService {
    @Override
    public void Relevancy(Long id, List<Long> tags) {
        tags.stream().forEach(
                tag ->
                {
                    save(new ArticleTag(id, tag));
                }
        );

    }
}




