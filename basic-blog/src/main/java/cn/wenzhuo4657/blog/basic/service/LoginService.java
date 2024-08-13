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



      /**
         *  des:登出用户，将redis中对应的用户缓存删除即可
       *  由于jwt过滤器编写代码中，当token无法查询信息时，直接响应给给前端登录失效，
         * */
    ResponseResult logout();
}