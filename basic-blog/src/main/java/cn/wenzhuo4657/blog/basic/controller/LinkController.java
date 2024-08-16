package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: LinkController
 * @author: wenzhuo4657
 * @date: 2024/8/16 11:27
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/link")
@Api(tags = "友链相关api")
public class LinkController {
    @PostMapping("/getAllLink")
    @PrintLog
    public ResponseResult getAllLink(){
        return loginService.logout();
    }
}