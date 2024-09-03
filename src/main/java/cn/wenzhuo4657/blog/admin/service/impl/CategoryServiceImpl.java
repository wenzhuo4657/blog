package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.dao.CategoryMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Category;
import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.domain.vo.CategoryDto;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.domain.vo.RoutersVo;
import cn.wenzhuo4657.blog.admin.service.CategoryService;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_category(分类表)】的数据库操作Service实现
* @createDate 2024-08-31 14:27:33
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService {

    private  CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getList() {
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        wrapper.select(Category::getId,Category::getName,Category::getDescription);
        wrapper.eq(Category::getStatus,0);
        List<Category> list = list(wrapper);
        List<CategoryDto> voList= BeancopyUtils.copyBeanList(list, CategoryDto.class);
        return voList;
    }

    @Override
    public PageVo getPage(Integer pageSize, Integer pageNum, CategoryDto categoryDto) {

        PageHelper.startPage(pageNum, pageSize);
        List<Category>  list=categoryMapper.selectByCategoryDto(categoryDto);
        PageInfo info=new PageInfo<>(list);
        PageVo vo=new PageVo(info.getList(),info.getTotal());
        return vo;
    }

    @Override
    public void delByID(long id) {
        categoryMapper.deleteById(id);
    }



    @Override
    public Category selectById(long id) {
        return categoryMapper.selectById(id);

    }
}




