package cn.wenzhuo4657.blog.basic.dao;

import cn.wenzhuo4657.blog.basic.domain.enity.Link;
import cn.wenzhuo4657.blog.basic.domain.vo.LinkVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_link(友链)】的数据库操作Mapper
* @createDate 2024-08-16 11:32:30
* @Entity generator.domain.Link
*/
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

    List<LinkVo> getAll(@Param("status") int status);
}




