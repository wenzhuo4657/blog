package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.service.UserService;
import cn.wenzhuo4657.blog.basic.dao.UserMapper;
import cn.wenzhuo4657.blog.basic.domain.enity.User;

import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoDto;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    private  UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public pageVo getPageVo(Integer pageNum, Integer pageSize, UserInfoDto vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list=userMapper.selectByUserDto(vo);
        PageInfo info=new PageInfo<>(list);
        pageVo pagevo=new pageVo(info.getList(),info.getTotal());
        return pagevo;
    }
}
