package cn.wenzhuo4657.blog.basic.service.impl;


import cn.wenzhuo4657.blog.basic.dao.CommentMapper;
import cn.wenzhuo4657.blog.basic.domain.enity.Comment;
import cn.wenzhuo4657.blog.basic.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author 86147
* @description 针对表【sg_comment(评论表)】的数据库操作Service实现
* @createDate 2024-08-15 15:15:42
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

}




