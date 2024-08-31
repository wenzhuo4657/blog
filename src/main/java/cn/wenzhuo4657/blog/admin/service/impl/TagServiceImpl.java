package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.dao.TagMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
* @author 86147
* @description 针对表【sg_tag(标签)】的数据库操作Service实现
* @createDate 2024-08-31 10:02:10
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

}




