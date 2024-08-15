package cn.wenzhuo4657.blog.basic.dao;


import cn.wenzhuo4657.blog.basic.domain.enity.SgCategory;
import cn.wenzhuo4657.blog.basic.domain.vo.CategoryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_category(分类表)】的数据库操作Mapper
* @createDate 2024-08-15 09:46:22
* @Entity generator.domain.SgCategory
*/
@Mapper
public interface SgCategoryMapper extends BaseMapper<SgCategory> {

      /**
         *  des:
       *   查询文章中，指定文章状态下的分类中指定分类状态下的分类名称集合
         * */
    List<CategoryVo> isStatus(@Param(value="articleStatusP")int articleStatusP, @Param(value ="categoryStatusP")int categoryStatusP);
}




