package cn.wenzhuo4657.blog.admin.service;



import cn.wenzhuo4657.blog.admin.domain.vo.LinkVo;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.basic.domain.enity.Link;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sg_link(友链)】的数据库操作Service
* @createDate 2024-09-03 08:34:45
*/
public interface LinkService extends IService<Link> {

    PageVo getPageVo(Integer pageNum, Integer pageSize, LinkVo linkVo);
}
