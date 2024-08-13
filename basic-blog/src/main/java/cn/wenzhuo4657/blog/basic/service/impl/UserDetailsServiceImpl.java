package cn.wenzhuo4657.blog.basic.service.impl;

import cn.wenzhuo4657.blog.basic.dao.UserHDao;
import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @className: UserDetailsServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/6/16 14:26
 * @Version: 1.0
 * @description:  springSecurity认证过滤链，定义查询用户数据的核心方法，将其加载到
 * 注意，该方法在过滤器中执行，
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserHDao userHDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserH> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(UserH::getUserName,username);
        UserH userH=userHDao.selectOne(wrapper);
        LoginUser loginUser =new LoginUser(userH,new ArrayList<>());
        return loginUser;

    }
}