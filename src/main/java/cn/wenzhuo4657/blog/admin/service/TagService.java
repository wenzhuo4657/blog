package cn.wenzhuo4657.blog.admin.service;


import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.domain.vo.TagVo;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sg_tag(标签)】的数据库操作Service
* @createDate 2024-08-31 10:02:10
*/
public interface TagService extends IService<Tag> {

    ResponseResult getlist(Integer pageNum, Integer pageSize, TagVo tagVo);

    ResponseResult insertTag(TagVo tagVo);
}
