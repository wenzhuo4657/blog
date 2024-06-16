package cn.wenzhuo4657.blog.basic;

import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Map;

/**
 * @className: Application
 * @author: wenzhuo4657
 * @date: 2024/6/11 11:10
 * @Version: 1.0
 * @description:
 */

@SpringBootApplication
@MapperScan("cn.wenzhuo4657.blog.basic.dao")
@EnableScheduling
@EnableSwagger2
public class Application {

    public static Map<String, String> copyOfContextMap;
    public static void main(String[] args) {
        MDC.put(HttpEnum.traceId,String.valueOf(Thread.currentThread().getId()));
        copyOfContextMap = MDC.getCopyOfContextMap();
        SpringApplication.run(Application.class,args);

    }
}