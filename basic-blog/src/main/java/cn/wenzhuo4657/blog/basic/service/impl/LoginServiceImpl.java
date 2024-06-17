package cn.wenzhuo4657.blog.basic.service.impl;

import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @className: LoginServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/6/16 15:26
 * @Version: 1.0
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    @Order(10000000)
    private AuthenticationManager authenticationManager;


    @Override
    public ResponseResult login(UserH user) {
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        authenticationManager.authenticate(token);
        return null;
    }
}