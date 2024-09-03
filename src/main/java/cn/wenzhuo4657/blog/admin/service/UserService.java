package cn.wenzhuo4657.blog.admin.service;

import cn.wenzhuo4657.blog.basic.domain.enity.User;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoDto;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {




    pageVo getPageVo(Integer pageNum, Integer pageSize, UserInfoDto vo);
}