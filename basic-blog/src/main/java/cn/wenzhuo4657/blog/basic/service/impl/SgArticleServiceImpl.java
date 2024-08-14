package cn.wenzhuo4657.blog.basic.service.impl;


import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.dao.SgArticleMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.SgArticle;
import cn.wenzhuo4657.blog.basic.domain.query.ArticleQuery;
import cn.wenzhuo4657.blog.basic.domain.vo.HotArtcleVo;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import cn.wenzhuo4657.blog.basic.service.SgArticleService;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_article(文章表)】的数据库操作Service实现
* @createDate 2024-08-13 12:47:04
*/
@Service
public class SgArticleServiceImpl extends ServiceImpl<SgArticleMapper, SgArticle>
    implements SgArticleService {

    private  SgArticleMapper sgArticleMapper;

    public SgArticleServiceImpl(SgArticleMapper sgArticleMapper) {
        this.sgArticleMapper = sgArticleMapper;
    }

    @Override
    public ResponseResult hot() {
        List<SgArticle> hotList=sgArticleMapper.selectHot(
                ArticleQuery.builder().
                        viewCount(10L).
                        build());
        List<HotArtcleVo> hotArtcleVos = BeancopyUtils.copyBeanList(hotList, HotArtcleVo.class);
        return ResponseResult.okResult(hotArtcleVos);
    }

    @Override
    public ResponseResult getarticleList(Integer pageNum, Integer pageSize, Integer categoryid) {
        PageHelper.startPage(pageNum,pageSize,false);
        List<SgArticle> list = sgArticleMapper.selectArticleList(categoryid, HttpEnum.articleStatusP);
        PageInfo<SgArticle>  info = new PageInfo<>(list);
        pageVo  pageVo =new pageVo(info.getList(),info.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}




