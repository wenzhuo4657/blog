package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.service.SgArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ArticleController
 * @author: wenzhuo4657
 * @date: 2024/8/13 12:34
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/article")
@Api(tags = "文章相关api")
public class ArticleController {



    private SgArticleService sgArticleService;

    public ArticleController(SgArticleService sgArticleService) {
        this.sgArticleService = sgArticleService;
    }

    @GetMapping(value = "/hotArticleList")
    @PrintLog
    @ApiOperation(value = "查询热门文章", notes ="默认查询前10热度，并且必须设置最低访问量")
    public ResponseResult hotArticleList(){
        return   sgArticleService.hot();
    }



    @GetMapping(value = "/articleList")
    @PrintLog
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" ,value = "页数"),
            @ApiImplicitParam(name = "pageSize",value = "页大小"),
            @ApiImplicitParam(name = "categoryId", value = "分类")
    }
    )
    @ApiOperation(value = "查询指定分类文章")
    public ResponseResult  articleList(Integer pageNum,Integer pageSize,Integer categoryId){
        return   sgArticleService.getarticleList(pageNum,pageSize,categoryId);
    }

}