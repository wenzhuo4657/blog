package cn.wenzhuo4657.blog.basic.service.impl;

import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoVo;
import cn.wenzhuo4657.blog.basic.domain.vo.UserLoginVo;
import cn.wenzhuo4657.blog.basic.service.LoginService;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import cn.wenzhuo4657.blog.basic.utils.JwtUtil;
import cn.wenzhuo4657.blog.basic.utils.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @className: LoginServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/6/16 15:26
 * @Version: 1.0
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {



    private AuthenticationManager authenticationManager;
    private RedisCache redisCache;

    public LoginServiceImpl(AuthenticationManager authenticationManager, RedisCache redisCache) {
        this.authenticationManager = authenticationManager;
        this.redisCache = redisCache;
    }

    @Override
    public ResponseResult login(UserH user) {
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticaation = authenticationManager.authenticate(token);
        if(Objects.isNull(authenticaation)){
            throw   new RuntimeException("用户名密码错误");
        }
        LoginUser  loginUser = (LoginUser) authenticaation.getPrincipal();
        String  id = loginUser.getUser().getId().toString();
        redisCache.setCacheObject(HttpEnum.redis_user+id,loginUser);
        String jwt= JwtUtil.createJWT(id);
        UserInfoVo vo= BeancopyUtils.copyBean(user,UserInfoVo.class);
        UserLoginVo loginVo=new UserLoginVo(jwt,vo);
        return ResponseResult.okResult(loginVo);
    }
}