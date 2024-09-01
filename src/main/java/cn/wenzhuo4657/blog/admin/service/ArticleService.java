package cn.wenzhuo4657.blog.admin.service;


import cn.wenzhuo4657.blog.admin.domain.enity.Article;
import cn.wenzhuo4657.blog.admin.domain.vo.ArticleDto;
import cn.wenzhuo4657.blog.admin.domain.vo.ArticleVo;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sg_article(文章表)】的数据库操作Service
* @createDate 2024-08-31 15:35:07
*/
public interface ArticleService extends IService<Article> {

    ResponseResult add(ArticleDto article);

    PageVo getPageVo(Integer pageNum, Integer pageSize, ArticleVo vo);
}
