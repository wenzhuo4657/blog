package cn.wenzhuo4657.blog.admin.controller.System;

import cn.wenzhuo4657.blog.admin.service.UserService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoDto;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserController
 * @author: wenzhuo4657
 * @date: 2024/9/3 9:06
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/system/user")
@Api("系统管理之用户管理")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取用户列表")
    @PrintLog
    public ResponseResult<pageVo> getTagList(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             UserInfoDto vo) {
        pageVo pageVo = userService.getPageVo(pageNum, pageSize, vo);
        return ResponseResult.okResult(pageVo);
    }

}