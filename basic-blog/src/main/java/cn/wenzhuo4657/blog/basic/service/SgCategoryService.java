package cn.wenzhuo4657.blog.basic.service;

import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.SgCategory;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sg_category(分类表)】的数据库操作Service
* @createDate 2024-08-15 09:46:22
*/
public interface SgCategoryService extends IService<SgCategory> {

    ResponseResult getList();
}
