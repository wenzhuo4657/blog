package cn.wenzhuo4657.blog.admin.dao;

import cn.wenzhuo4657.blog.admin.domain.enity.ArticleTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_article_tag(文章标签关联表)】的数据库操作Mapper
* @createDate 2024-09-01 09:21:18
* @Entity generator.domain.ArticleTag
*/
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {


}




