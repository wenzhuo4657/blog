package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.Comment;
import cn.wenzhuo4657.blog.basic.domain.vo.CommentDto;
import cn.wenzhuo4657.blog.basic.service.CommentService;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @className: CommentController
 * @author: wenzhuo4657
 * @date: 2024/8/15 15:12
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/comment")
@Api(tags = "评论相关api")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/commentList")
    @PrintLog
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" ,value = "页数"),
            @ApiImplicitParam(name = "pageSize",value = "页大小"),
            @ApiImplicitParam(name = "articleId", value = "文章iD")
    }
    )
    @ApiOperation(value = "查询评论列表")
    public ResponseResult commentList(Integer pageNum, Integer pageSize, Integer articleId){
        return   commentService.commentList(HttpEnum.comment_Article,pageNum,pageSize,articleId+0L);
    }
    @GetMapping("linkCommentList")
    public ResponseResult LinkCommentList(Integer pageNum,Integer pageSize){
        return  commentService.commentList(HttpEnum.comment_LiNK,pageNum,pageNum,1L);
    }


    @PostMapping
    public  ResponseResult addComment(@RequestBody CommentDto commentDto){
        Comment comment= BeancopyUtils.copyBean(commentDto, Comment.class);
        return  commentService.add(comment);
    }


}