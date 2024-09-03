package cn.wenzhuo4657.blog.basic.service.impl;

import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.dao.UserMapper;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.User;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoDto;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoVo;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import cn.wenzhuo4657.blog.basic.exception.SystemException;
import cn.wenzhuo4657.blog.basic.service.UserService;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author 86147
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2024-08-15 12:46:57
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper;


    public UserServiceImpl(PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

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

    @Override
    public ResponseResult register(User user) {
        if (!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.Username_not_NULL);
        }
        if (!StringUtils.hasText(user.getEmail()) ){
            throw new SystemException(AppHttpCodeEnum.Email_not_NULL);
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new SystemException(AppHttpCodeEnum.Password_not_NULL);

        }

        String endcode=passwordEncoder.encode(user.getPassword());
        user.setPassword(endcode);
        save(user);
        return ResponseResult.okResult();
    }


}




