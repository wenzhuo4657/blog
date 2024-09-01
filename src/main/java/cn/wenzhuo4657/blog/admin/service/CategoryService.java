package cn.wenzhuo4657.blog.admin.service;


import cn.wenzhuo4657.blog.admin.domain.enity.Category;
import cn.wenzhuo4657.blog.admin.domain.vo.CategoryDto;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.domain.vo.RoutersVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_category(分类表)】的数据库操作Service
* @createDate 2024-08-31 14:27:33
*/
public interface CategoryService extends IService<Category> {

    List<CategoryDto> getList();

    PageVo getPage(Integer pageSize, Integer pageNum, CategoryDto categoryDto);
}
