package cn.wenzhuo4657.blog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@MapperScan
@EnableWebSecurity
@EnableSwagger2
public class application {

    public static void main(String[] args) {
        SpringApplication.run(application.class,args);
    }
}