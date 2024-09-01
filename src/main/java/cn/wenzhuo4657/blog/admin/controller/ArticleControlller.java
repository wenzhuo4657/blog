package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.domain.vo.ArticleDto;
import cn.wenzhuo4657.blog.admin.service.ArticleService;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ArticleControlller
 * @author: wenzhuo4657
 * @date: 2024/8/31 15:34
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/content/article")
public class ArticleControlller {

    private ArticleService articleService;

    public ArticleControlller(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseResult add(@RequestBody ArticleDto article){
        return articleService.add(article);
    }

}