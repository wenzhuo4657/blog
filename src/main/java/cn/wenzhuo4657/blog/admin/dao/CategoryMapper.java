package cn.wenzhuo4657.blog.admin.dao;

import cn.wenzhuo4657.blog.admin.domain.enity.Category;
import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.domain.vo.CategoryDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_category(分类表)】的数据库操作Mapper
* @createDate 2024-08-31 14:27:33
* @Entity generator.domain.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> selectByCategoryDto(CategoryDto categoryDto);
}




