package cn.wenzhuo4657.blog.basic.service;


import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.Link;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sg_link(友链)】的数据库操作Service
* @createDate 2024-08-16 11:32:30
*/
public interface LinkService extends IService<Link> {

    ResponseResult getAll();
}
