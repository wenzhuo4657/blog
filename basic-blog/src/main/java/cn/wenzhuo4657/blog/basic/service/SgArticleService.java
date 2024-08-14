package cn.wenzhuo4657.blog.basic.service;


import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.SgArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sg_article(文章表)】的数据库操作Service
* @createDate 2024-08-13 12:47:04
*/
public interface SgArticleService extends IService<SgArticle> {

    ResponseResult hot();

    ResponseResult getarticleList(Integer pageNum, Integer pageSize, Integer categoryid);
}
