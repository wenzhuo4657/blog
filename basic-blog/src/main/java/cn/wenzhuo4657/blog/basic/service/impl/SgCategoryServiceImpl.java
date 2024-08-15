package cn.wenzhuo4657.blog.basic.service.impl;


import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.dao.SgArticleMapper;
import cn.wenzhuo4657.blog.basic.dao.SgCategoryMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.SgCategory;
import cn.wenzhuo4657.blog.basic.service.SgCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86147
* @description 针对表【sg_category(分类表)】的数据库操作Service实现
* @createDate 2024-08-15 09:46:22
*/
@Service
public class SgCategoryServiceImpl extends ServiceImpl<SgCategoryMapper, SgCategory>
    implements SgCategoryService {

    private  SgCategoryMapper sgCategoryMapper;
    private SgArticleMapper sgArticleMapper;

    public SgCategoryServiceImpl(SgCategoryMapper sgCategoryMapper) {
        this.sgCategoryMapper = sgCategoryMapper;
    }

    @Autowired
    public SgCategoryServiceImpl(SgCategoryMapper sgCategoryMapper, SgArticleMapper sgArticleMapper) {
        this.sgCategoryMapper = sgCategoryMapper;
        this.sgArticleMapper = sgArticleMapper;
    }

    @Override
    public ResponseResult getList() {
        return     ResponseResult.okResult(sgCategoryMapper.isStatus(HttpEnum.articleStatusP,HttpEnum.categoryStatusP));
    }
}




