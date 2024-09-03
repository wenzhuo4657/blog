package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.domain.vo.LinkDto;
import cn.wenzhuo4657.blog.admin.domain.vo.LinkVo;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.service.LinkService;

import cn.wenzhuo4657.blog.basic.dao.LinkMapper;
import cn.wenzhuo4657.blog.basic.domain.enity.Link;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @author 86147
* @description 针对表【sg_link(友链)】的数据库操作Service实现
* @createDate 2024-09-03 08:34:45
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link>
    implements LinkService {
    @Override
    public PageVo getPageVo(Integer pageNum, Integer pageSize, LinkVo linkVo) {
        PageHelper.startPage(pageNum,pageSize);
        LambdaQueryWrapper<Link> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Link::getDelFlag,0);
        if (!Objects.isNull(linkVo)) {
            wrapper.eq(linkVo.getName()!=null,Link::getName,linkVo.getName());
            wrapper.eq(linkVo.getStatus()!=null,Link::getStatus,linkVo.getStatus());
        }
        List<Link> list = list(wrapper);
        PageInfo info=new PageInfo<>(list);
        List<LinkDto> volist= BeancopyUtils.copyBeanList(list, LinkDto.class);
        PageVo vo =new PageVo(volist,info.getTotal());
        return vo;
    }
}




