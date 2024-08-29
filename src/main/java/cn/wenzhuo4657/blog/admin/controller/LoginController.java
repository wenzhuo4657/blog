package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.domain.vo.AdminUserInfoVo;
import cn.wenzhuo4657.blog.admin.service.Admin_LoginService;
import cn.wenzhuo4657.blog.admin.service.MenuService;
import cn.wenzhuo4657.blog.admin.service.RoleService;
import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @className: LoginController
 * @author: wenzhuo4657
 * @date: 2024/8/27 10:54
 * @Version: 1.0
 * @description:
 */
@RestController
@Api("管理员登录")
public class LoginController {

    private Admin_LoginService loginService;

    private MenuService menuService;
    private RoleService roleService;


    public LoginController(Admin_LoginService loginService, MenuService menuService, RoleService roleService) {
        this.loginService = loginService;
        this.menuService = menuService;
        this.roleService = roleService;
    }


    @PostMapping("/user/login")
    @ApiOperation(notes = "用户名不能为空",value = "登入")
    @PrintLog
    public ResponseResult login(@RequestBody UserH user){
        if (!StringUtils.hasText(user.getUserName())){
            throw  new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);//简单校验，
        }
        return loginService.login(user);
    }

    @GetMapping("/getInfo")
    @ApiOperation(notes = "用户名不能为空",value = "登入")
    @PrintLog
    public ResponseResult<AdminUserInfoVo> getInfo(){
        LoginUser loginUser = SecurityUtils.getLoginUser();

        return ResponseResult.okResult(new AdminUserInfoVo());
    }


}