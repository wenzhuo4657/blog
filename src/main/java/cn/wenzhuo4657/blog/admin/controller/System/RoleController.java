package cn.wenzhuo4657.blog.admin.controller.System;

import cn.wenzhuo4657.blog.admin.domain.enity.Role;
import cn.wenzhuo4657.blog.admin.domain.vo.RoleVo;
import cn.wenzhuo4657.blog.admin.service.RoleService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @className: RoleController
 * @author: wenzhuo4657
 * @date: 2024/9/3 9:19
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/system/role")
@Api("系统管理之角色管理")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取角色列表")
    @PrintLog
    public ResponseResult<pageVo> getTagList(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             RoleVo vo) {
        pageVo pageVo = roleService.getPageVo(pageNum, pageSize, vo);
        return ResponseResult.okResult(pageVo);
    }

    @PutMapping("/changeStatus")
    @ApiOperation(value = "根据id改变角色的状态，")
    @PrintLog
    public ResponseResult changeStatus(@RequestBody RoleVo vo) {
        roleService.updateById(new Role(vo.getRoleId(), vo.getStatus()));
        return ResponseResult.okResult();
    }

}