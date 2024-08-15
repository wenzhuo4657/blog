package cn.wenzhuo4657.blog.basic.dao;


import cn.wenzhuo4657.blog.basic.domain.enity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86147
* @description 针对表【sg_comment(评论表)】的数据库操作Mapper
* @createDate 2024-08-15 15:15:42
* @Entity generator.domain.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}




