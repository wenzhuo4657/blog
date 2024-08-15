package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: CommentController
 * @author: wenzhuo4657
 * @date: 2024/8/15 15:12
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/category")
@Api(tags = "评论相关api")
public class CommentController {
//    commentList?pageNum=1&pageSize=10&articleId=1


    @GetMapping(value = "/commentList")
    @PrintLog
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" ,value = "页数"),
            @ApiImplicitParam(name = "pageSize",value = "页大小"),
            @ApiImplicitParam(name = "articleId", value = "文章iD")
    }
    )
    @ApiOperation(value = "评论列表")
    public ResponseResult commentList(Integer pageNum, Integer pageSize, Integer categoryId){
        return   null;
    }
}