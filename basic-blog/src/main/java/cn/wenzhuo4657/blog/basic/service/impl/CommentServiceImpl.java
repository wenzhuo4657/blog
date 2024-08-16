package cn.wenzhuo4657.blog.basic.service.impl;


import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.dao.CommentMapper;
import cn.wenzhuo4657.blog.basic.dao.UserMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.Comment;
import cn.wenzhuo4657.blog.basic.domain.enity.SgArticle;
import cn.wenzhuo4657.blog.basic.domain.vo.CommentVo;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_comment(评论表)】的数据库操作Service实现
* @createDate 2024-08-15 15:15:42
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

    private  CommentMapper commentMapper;

    private UserMapper userMapper;

    public CommentServiceImpl(CommentMapper commentMapper, UserMapper userMapper) {
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseResult commentList(int type, Integer pageNum, Integer pageSize, Long articleId) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommentVo> list = commentMapper.getCommentList(type, articleId, -1);
        xxVoList(list);
        list.forEach( vo->{
            List<CommentVo> children = getchildren(vo);
            xxVoList(children);
            vo.setChildren(children);
        });
        PageInfo<CommentVo>  info = new PageInfo<>(list);
        return ResponseResult.okResult(new pageVo(list, info.getTotal()));
    }

    @Override
    public ResponseResult add(Comment comment) {
        if (!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);
        return ResponseResult.okResult();
    }

    public  void xxVo(CommentVo vo){
        vo.setToCommentUserName(userMapper.selectById_nickName(vo.getToCommentUserId()));
        vo.setUsername(userMapper.selectById_nickName(vo.getCreateBy()));
    }
    public void xxVoList(List<CommentVo> list){
        list.stream().forEach( vo->xxVo(vo));
    }

    public  List<CommentVo> getchildren(CommentVo vo){
        return commentMapper.selectChildren(vo.getId());
    }

}




