package cn.wenzhuo4657.blog.basic.dao;


import cn.wenzhuo4657.blog.basic.domain.enity.SgArticle;
import cn.wenzhuo4657.blog.basic.domain.query.ArticleQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_article(文章表)】的数据库操作Mapper
* @createDate 2024-08-13 12:47:04
* @Entity generator.domain.SgArticle
*/
@Mapper
public interface SgArticleMapper extends BaseMapper<SgArticle> {

    List<SgArticle> selectHot( ArticleQuery query);

    List<SgArticle> selectArticleList(@Param(value ="categoryid")Integer categoryid,@Param(value ="status")int status);
}




