package cn.wenzhuo4657.blog.basic.controller;

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
public class test {

    @RequestMapping(value = "/hello")
    public  void print(){
        System.out.println("这是测试");
        System.out.println("MDc:"+ MDC.get("traceId"));

    }
}