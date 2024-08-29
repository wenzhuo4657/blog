package cn.wenzhuo4657.blog.admin.service.impl;


import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.admin.service.Admin_LoginService;
import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.domain.enity.UserH;
import cn.wenzhuo4657.blog.basic.utils.JwtUtil;
import cn.wenzhuo4657.blog.basic.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @className: AdminServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/8/27 11:03
 * @Version: 1.0
 * @description:
 */
@Service
public class AdminServiceImpl implements Admin_LoginService {
    private AuthenticationManager manager;

    private RedisCache redisCache;

    public AdminServiceImpl(AuthenticationManager manager, RedisCache redisCache) {
        this.manager = manager;
        this.redisCache = redisCache;
    }

    @Override
    public ResponseResult login(UserH user) {
        UsernamePasswordAuthenticationToken token=
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = manager.authenticate(token);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }

        LoginUser principal = (LoginUser)authenticate.getPrincipal();
        String id =principal.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);

        redisCache.setCacheObject(Code.redis_Admin+id,principal);

        Map<String ,String> map=new HashMap<>();
        map.put("token",jwt);
        return ResponseResult.okResult(map);
    }
}