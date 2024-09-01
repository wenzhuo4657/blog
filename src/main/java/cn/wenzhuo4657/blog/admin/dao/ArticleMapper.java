package cn.wenzhuo4657.blog.admin.dao;


import cn.wenzhuo4657.blog.admin.domain.enity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86147
* @description 针对表【sg_article(文章表)】的数据库操作Mapper
* @createDate 2024-08-31 15:35:07
* @Entity generator.domain.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




