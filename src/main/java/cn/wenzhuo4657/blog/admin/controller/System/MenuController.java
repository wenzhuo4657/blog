package cn.wenzhuo4657.blog.admin.controller.System;

import cn.wenzhuo4657.blog.admin.domain.enity.Menu;
import cn.wenzhuo4657.blog.admin.domain.vo.MenuVo;
import cn.wenzhuo4657.blog.admin.domain.vo.RoleVo;
import cn.wenzhuo4657.blog.admin.service.MenuService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: MenuController
 * @author: wenzhuo4657
 * @date: 2024/9/3 9:25
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/system/menu")
@Api("系统管理之菜单管理")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取菜单列表")
    @PrintLog
    public ResponseResult getTagList() {
        List<MenuVo> list=menuService.getAll();

        return  ResponseResult.okResult(list);
    }
}