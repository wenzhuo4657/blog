package cn.wenzhuo4657.blog.admin.service;

import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;

/**
 * @className: AdminService
 * @author: wenzhuo4657
 * @date: 2024/8/27 11:03
 * @Version: 1.0
 * @description:
 */
public interface Admin_LoginService {
    ResponseResult login(UserH user);
}