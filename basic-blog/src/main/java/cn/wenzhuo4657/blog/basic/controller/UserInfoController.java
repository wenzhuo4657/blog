package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.User;
import cn.wenzhuo4657.blog.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @className: UserInfoController
 * @author: wenzhuo4657
 * @date: 2024/8/15 12:41
 * @Version: 1.0
 * @description:
 */

@RestController
@Api(tags = "用户信息相关api")
@RequestMapping("/user")
public class UserInfoController {

    private UserService userService;

    public UserInfoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/userInfo")
    @PrintLog
    @ApiOperation(value = "查询userinfo")
    public ResponseResult getUserInfo(@RequestParam("userId") Integer userId){
        return   userService.getUserVo();
    }

    @PutMapping("/userInfo")
    @PrintLog
    @ApiOperation(value = "更新userinfo")
    public  ResponseResult updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    @PrintLog
    @ApiOperation(value = "注册")
    public  ResponseResult register(@RequestBody  User user){
        return  userService.register(user);
    }
}