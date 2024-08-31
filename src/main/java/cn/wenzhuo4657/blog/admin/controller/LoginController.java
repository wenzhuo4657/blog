package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.admin.domain.vo.AdminUserInfoVo;
import cn.wenzhuo4657.blog.admin.domain.vo.RoutersVo;
import cn.wenzhuo4657.blog.admin.service.Admin_LoginService;
import cn.wenzhuo4657.blog.admin.service.MenuService;
import cn.wenzhuo4657.blog.admin.service.RoleService;
import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoVo;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import cn.wenzhuo4657.blog.basic.utils.RedisCache;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    private RedisCache redisCache;


    @Autowired
    public LoginController(Admin_LoginService loginService, MenuService menuService, RoleService roleService, RedisCache redisCache) {
        this.loginService = loginService;
        this.menuService = menuService;
        this.roleService = roleService;
        this.redisCache = redisCache;
    }


    @PostMapping("/user/login")
    @ApiOperation(notes = "用户名不能为空", value = "登入")
    @PrintLog
    public ResponseResult login(@RequestBody UserH user) {
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);//简单校验，
        }
        return loginService.login(user);
    }

    @GetMapping("/getInfo")
    @ApiOperation(value = "获取权限和角色信息")
    @PrintLog
    public ResponseResult<AdminUserInfoVo> getInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        UserInfoVo userInfo = BeancopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        List<String> list_role = roleService.getRoleById(userInfo.getId());
        List<String> list_menu = menuService.getPermsById(userInfo.getId());

        return ResponseResult.okResult(new AdminUserInfoVo(list_menu, list_role, userInfo));
    }

    @GetMapping("/getRouters")
    @ApiOperation(value = "获取动态路由,实质上就是根据id动态的获取菜单信息，返回给前端以展示不同的页面。")
    @PrintLog
    public ResponseResult<RoutersVo> getRouters() {
        Long userId = SecurityUtils.getUserId();
        return ResponseResult.okResult(new RoutersVo(menuService.getRoutersTree(userId)));
    }

    @PostMapping("/user/logout")
    @ApiOperation(value = "登出")
    @PrintLog
    public ResponseResult logout() {
        Long userId = SecurityUtils.getUserId();
        redisCache.deleteObject(Code.redis_Admin+userId);
        return ResponseResult.okResult();
    }


}