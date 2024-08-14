package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @className: LoginController
 * @author: wenzhuo4657
 * @date: 2024/6/14 15:29
 * @Version: 1.0
 * @description:
 */
@RestController
@Api(tags = "登录相关api")
public class LoginController {


    private LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    @ApiOperation(notes = "用户名不能为空",value = "登入")
    @PrintLog
    public ResponseResult login(@RequestBody UserH user){
        if (!StringUtils.hasText(user.getUserName())){
            throw  new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);//简单校验，
        }
        return loginService.login(user);
    }


    @PostMapping("/logout")
    @ApiOperation(value = "登出")
    @PrintLog
    public ResponseResult logout(){
        return loginService.logout();
    }


}