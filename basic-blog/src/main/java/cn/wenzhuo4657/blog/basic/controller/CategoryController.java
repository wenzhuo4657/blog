package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.dao.SgCategoryMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.service.SgCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: CategoryController
 * @author: wenzhuo4657
 * @date: 2024/8/15 9:29
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类相关api")
public class CategoryController {


    private SgCategoryService sgCategoryService;

    public CategoryController(SgCategoryService sgCategoryService) {
        this.sgCategoryService = sgCategoryService;
    }

    @GetMapping(value = "/getCategoryList")
    @PrintLog
    @ApiOperation(value = "获取分类列表",notes = "此接口为用户接口，其查询的真实语义为，可发布的文章的所有分类中的可发布分类列表，这意味着该接口的数据是动态生成的，而非简单的查询分类表")
    public ResponseResult getCategoryList(){
        return sgCategoryService.getList();
    }

}