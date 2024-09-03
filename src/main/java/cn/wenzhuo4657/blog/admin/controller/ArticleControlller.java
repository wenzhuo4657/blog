package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.domain.vo.ArticleDto;
import cn.wenzhuo4657.blog.admin.domain.vo.ArticleVo;
import cn.wenzhuo4657.blog.admin.domain.vo.CategoryDto;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.service.ArticleService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    @ApiOperation(value = "获取列表")
    @PrintLog
    public ResponseResult<PageVo> list(@RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize,
                                                  ArticleVo vo) {


        return ResponseResult.okResult(articleService.getPageVo(pageNum,pageSize,vo));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除文章")
    @PrintLog
    public ResponseResult del(@PathVariable("id") long id) {
        articleService.delByID(id);
        return ResponseResult.okResult();
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "获取文章dto")
    @PrintLog
    public ResponseResult<ArticleDto> get(@PathVariable("id") long id) {
        ArticleDto dto = articleService.getByID(id);
        return ResponseResult.okResult(dto);
    }
    @PutMapping()
    @ApiOperation(value = "更新文章")
    @PrintLog
    public ResponseResult updata(@RequestBody ArticleDto dto) {
         articleService.updataById(dto);
        return ResponseResult.okResult();
    }

}