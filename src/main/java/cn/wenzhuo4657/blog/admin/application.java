package cn.wenzhuo4657.blog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: application
 * @author: wenzhuo4657
 * @date: 2024/8/17 9:49
 * @Version: 1.0
 * @description:
 */


@SpringBootApplication
@EnableWebSecurity
@EnableSwagger2
@ComponentScan(
        basePackages = "cn.wenzhuo4657.blog"
        , excludeFilters = {
                        @ComponentScan.Filter(type = FilterType.REGEX, pattern = {
                                "cn.wenzhuo4657.blog.basic.controller.*",
                                "cn.wenzhuo4657.blog.basic.service.*",
                                "cn.wenzhuo4657.blog.basic.Application"
                        })
                }
        )
@MapperScan("cn.wenzhuo4657.blog.basic.dao")
public class application {

    public static void main(String[] args) {
        SpringApplication.run(application.class,args);
    }
}