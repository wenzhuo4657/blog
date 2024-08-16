package cn.wenzhuo4657.blog.basic;

import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.dao.SgArticleMapper;
import cn.wenzhuo4657.blog.basic.domain.enity.SgArticle;
import cn.wenzhuo4657.blog.basic.utils.RedisCache;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @className: Application
 * @author: wenzhuo4657
 * @date: 2024/6/11 11:10
 * @Version: 1.0
 * @description:
 */

@SpringBootApplication
@MapperScan("cn.wenzhuo4657.blog.basic.dao")
@EnableWebSecurity
public class Application implements CommandLineRunner {





    public static void main(String[] args) {
        MDC.put(HttpEnum.traceId,String.valueOf(Thread.currentThread().getId()));
        copyOfContextMap = MDC.getCopyOfContextMap();
        SpringApplication.run(Application.class,args);
    }
    public static Map<String, String> copyOfContextMap;

    private SgArticleMapper sgArticleMapper;

    private RedisCache redisCache;




    @Autowired
    public Application(SgArticleMapper sgArticleMapper, RedisCache redisCache) {
        this.sgArticleMapper = sgArticleMapper;
        this.redisCache = redisCache;
    }


    @Override
    public void run(String... args) throws Exception {

       List<SgArticle> list=sgArticleMapper.getViewcountMap();
        Map<String,Integer> ViewCountMap=list.stream().collect(Collectors.toMap(
                sgArticle -> sgArticle.getId().toString()
                , sgArticle -> sgArticle.getViewCount().intValue()));
        redisCache.setCacheMap(HttpEnum.article_viewCount,ViewCountMap);
    }



}