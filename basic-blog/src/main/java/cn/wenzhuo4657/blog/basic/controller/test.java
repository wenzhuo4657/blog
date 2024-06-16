package cn.wenzhuo4657.blog.basic.controller;

import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/6/15 14:15
 * @Version: 1.0
 * @description:
 */
@RestController
@Slf4j
public class test {

    @RequestMapping(value = "/hello")
    @PrintLog
    public  int print(int a){
        return a*10;

    }
}