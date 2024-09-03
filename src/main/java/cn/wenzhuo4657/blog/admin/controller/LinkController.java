package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.domain.vo.LinkVo;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.service.LinkService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: LinkController
 * @author: wenzhuo4657
 * @date: 2024/9/1 11:35
 * @Version: 1.0
 * @description:
 */
@RestController
@Api("友链管理")
@RequestMapping("/content/link")
public class LinkController {
    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取友链列表")
    @PrintLog
    public ResponseResult<PageVo> getTagList(@RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     LinkVo LinkVo) {
        PageVo pageVo=linkService.getPageVo(pageNum,pageSize,LinkVo);
        return  ResponseResult.okResult(pageVo);
    }
}