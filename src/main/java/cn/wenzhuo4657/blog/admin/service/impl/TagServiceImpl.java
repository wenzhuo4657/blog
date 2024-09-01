package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.dao.TagMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.domain.vo.TagVo;
import cn.wenzhuo4657.blog.admin.service.TagService;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Objects;

/**
* @author 86147
* @description 针对表【sg_tag(标签)】的数据库操作Service实现
* @createDate 2024-08-31 10:02:10
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

    private  TagMapper tagMapper;

    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public ResponseResult getlist( Integer pageNum, Integer pageSize, TagVo tagVo) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag>  list=tagMapper.selectByTagvo(tagVo);
        PageInfo info=new PageInfo<>(list);
        PageVo vo=new PageVo(info.getList(),info.getTotal());
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult insertTag( TagVo tagVo) {
        Tag tag= BeancopyUtils.copyBean(tagVo,Tag.class);
        tagMapper.insert(tag);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult<TagVo> getAllTag() {
        LambdaQueryWrapper<Tag> wrapper=new LambdaQueryWrapper<>();
        wrapper.select(Tag::getId,Tag::getName);
        List<Tag> list = list(wrapper);
        List<TagVo> voList=BeancopyUtils.copyBeanList(list,TagVo.class);
        return ResponseResult.okResult(voList);
    }
}




