package cn.wenzhuo4657.blog.basic.service;

import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;

/**
 * @className: LoginService
 * @author: wenzhuo4657
 * @date: 2024/6/16 15:26
 * @Version: 1.0
 * @description:
 */
public interface LoginService {
    ResponseResult login(UserH user);
}