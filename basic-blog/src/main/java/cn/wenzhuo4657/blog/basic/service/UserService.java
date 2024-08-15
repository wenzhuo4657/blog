package cn.wenzhuo4657.blog.basic.service;


import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86147
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2024-08-15 12:46:57
*/
public interface UserService extends IService<User> {

    ResponseResult getUserVo();

    ResponseResult updateUserInfo(User user);
}
