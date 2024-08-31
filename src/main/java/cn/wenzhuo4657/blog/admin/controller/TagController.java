package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.admin.domain.vo.TagVo;
import cn.wenzhuo4657.blog.admin.service.TagService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

/**
 * @className: TagController
 * @author: wenzhuo4657
 * @date: 2024/8/31 10:00
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/content/tag")
@Api("标签")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取可用标签列表")
    @PrintLog
    public ResponseResult  getTagList(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize,
                                    TagVo tagVo) {
        return  tagService.getlist(pageNum,pageSize,tagVo);
    }

    @PostMapping()
    @ApiOperation(value = "获取可用标签列表")
    @PrintLog
    public ResponseResult  InsertTag(@RequestBody TagVo tagVo) {
        return  tagService.insertTag(tagVo);
    }



}