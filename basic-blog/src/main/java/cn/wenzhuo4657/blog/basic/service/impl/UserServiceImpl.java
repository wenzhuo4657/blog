package cn.wenzhuo4657.blog.basic.service.impl;

import cn.wenzhuo4657.blog.basic.dao.UserMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.User;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoVo;
import cn.wenzhuo4657.blog.basic.service.UserService;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
* @author 86147
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2024-08-15 12:46:57
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
    @Override
    public ResponseResult getUserVo() {
        User user = getById(SecurityUtils.getUserId());
        UserInfoVo  vo = BeancopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }
}




