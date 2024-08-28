package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.service.Admin_LoginService;
import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.service.LoginService;
import cn.wenzhuo4657.blog.basic.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: LoginController
 * @author: wenzhuo4657
 * @date: 2024/8/27 10:54
 * @Version: 1.0
 * @description:
 */
@RestController
@Api("管理员登录")
@RequestMapping("/user")
public class LoginController {

    private Admin_LoginService loginService;


    public LoginController(Admin_LoginService loginService) {
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


}