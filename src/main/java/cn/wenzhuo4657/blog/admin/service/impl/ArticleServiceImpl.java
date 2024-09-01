package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.dao.ArticleMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Article;
import cn.wenzhuo4657.blog.admin.domain.vo.ArticleDto;
import cn.wenzhuo4657.blog.admin.service.ArticleService;
import cn.wenzhuo4657.blog.admin.service.ArticleTagService;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 86147
* @description 针对表【sg_article(文章表)】的数据库操作Service实现
* @createDate 2024-08-31 15:35:07
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {
    private ArticleTagService articleTagService;

    public ArticleServiceImpl(ArticleTagService articleTagService) {
        this.articleTagService = articleTagService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult add(ArticleDto article) {
        //  wenzhuo TODO 2024/9/1 : 没有默认选择，在前端不选择的情况下，部分属性，如分类id会作为null传递给后端，
        //  wenzhuo TODO 2024/9/1 : 图传也有问题，无法显示，似乎是访问速度的问题。
        //  wenzhuo TODO 2024/9/1 : istop有问题，有很多idtop=1表示置顶？？？？？
        Article bean = BeancopyUtils.copyBean(article, Article.class);
        save(bean);
        articleTagService.Relevancy(article.getId(),article.getTags());
        return ResponseResult.okResult();
    }
}




