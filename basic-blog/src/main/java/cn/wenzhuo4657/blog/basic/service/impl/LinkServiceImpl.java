package cn.wenzhuo4657.blog.basic.service.impl;

import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.dao.LinkMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.Link;
import cn.wenzhuo4657.blog.basic.domain.vo.LinkVo;
import cn.wenzhuo4657.blog.basic.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_link(友链)】的数据库操作Service实现
* @createDate 2024-08-16 11:32:30
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link>
    implements LinkService {
    private  LinkMapper linkMapper;

    public LinkServiceImpl(LinkMapper linkMapper) {
        this.linkMapper = linkMapper;
    }

    @Override
    public ResponseResult getAll() {
        List<LinkVo> list=linkMapper.getAll(HttpEnum.Link_status_P);
        return ResponseResult.okResult(list);
    }
}




