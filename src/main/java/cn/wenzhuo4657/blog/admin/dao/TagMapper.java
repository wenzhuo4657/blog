package cn.wenzhuo4657.blog.admin.dao;


import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86147
* @description 针对表【sg_tag(标签)】的数据库操作Mapper
* @createDate 2024-08-31 10:02:10
* @Entity generator.domain.Tag
*/
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}




