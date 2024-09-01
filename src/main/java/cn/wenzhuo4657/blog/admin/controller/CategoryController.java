package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.domain.enity.Category;
import cn.wenzhuo4657.blog.admin.domain.vo.*;
import cn.wenzhuo4657.blog.admin.service.CategoryService;
import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.vo.CategoryVo;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import cn.wenzhuo4657.blog.basic.utils.WebUtils;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @className: CategoryController
 * @author: wenzhuo4657
 * @date: 2024/8/31 14:25
 * @Version: 1.0
 * @description:
 */
@RestController
@Api("分类")
@RequestMapping("/content/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listAllCategory")
    @ApiOperation(value = "获取所有分类")
    @PrintLog
    public ResponseResult<RoutersVo> listAllCategory() {
        return ResponseResult.okResult(categoryService.getList());
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取分页")
    @PrintLog
    public ResponseResult<PageVo> listAllCategory(@RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize,
                                                  CategoryDto categoryDto) {


        return ResponseResult.okResult(categoryService.getPage(pageSize,pageNum,categoryDto));
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出分类到excel中")
    @PrintLog
    @PreAuthorize("@ps.hasPermission('content:category:export')")
    public void export(HttpServletResponse response) {

        try{
            WebUtils.setDownLoadHeader("分类.xlsx",response);
            List<Category> LIST=categoryService.list();
            List<CategoryVo> vo= BeancopyUtils.copyBeanList(LIST, CategoryVo.class);
            EasyExcel.
                    write(response.getOutputStream(), ExcelCategoryVo.class)
                    .autoCloseStream(Boolean.FALSE).sheet("文章分类")
                    .doWrite(vo);



        } catch (Exception e) {
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            WebUtils.renderString(response, JSON.toJSONString(result));
            throw new RuntimeException(e);
        }
    }
}