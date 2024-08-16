package cn.wenzhuo4657.blog.basic.dao;


import cn.wenzhuo4657.blog.basic.domain.enity.Comment;
import cn.wenzhuo4657.blog.basic.domain.vo.CommentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_comment(评论表)】的数据库操作Mapper
* @createDate 2024-08-15 15:15:42
* @Entity generator.domain.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
      /**
         *  des:
       *  type:评论主题：文章 or友链
       *  articleId:评论主体id 如果是友链其id只能是1
       *  isRoot :是否是根评论
         * */

    List<CommentVo> getCommentList(@Param("type")int type, @Param("articleId") Long articleId, @Param("isRoot") int isRoot);

    List<CommentVo> selectChildren(Long id);
}




