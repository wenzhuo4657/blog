package cn.wenzhuo4657.blog.basic.Filter.SpringSecurity;


import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.utils.JwtUtil;
import cn.wenzhuo4657.blog.basic.utils.RedisCache;
import cn.wenzhuo4657.blog.basic.utils.WebUtils;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @className: JwtAuthenticationToken
 * @author: wenzhuo4657
 * @date: 2024/6/17 14:50
 * @Version: 1.0
 * @description:  token验证，
 * 这里需要将其作为springSecurity过滤器链的第一个过滤器，其实际含义为：
 * 如果存在合法token,则将其认证过程中查询用户信息部分自定义，也就是说替代了loadUserByUsername方法，
 *
 *
 * 该过滤器 OncePerRequestFilter为spring框架提供的扩展点，相较于filter，该过滤器会保证在一个请求中该过滤器只会执行一次，
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private RedisCache redisCache;


    @Autowired
    public JwtAuthenticationTokenFilter(RedisCache redisCache) {
        this.redisCache = redisCache;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String token = (String)request.getAttribute("token");
        if (!StringUtils.hasText(token)){
            chain.doFilter(request,response);
            return;
        }

        Claims claims =null;
        try {
            claims = JwtUtil.parseJWT(token);
            String userid=claims.getSubject();
        } catch (Exception e) {
            ResponseResult result=ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            e.printStackTrace();
        }


        //  wenzhuo TODO 2024/6/17 : 根据userid从redis中获取缓存

        String userId=claims.getSubject();
        LoginUser loginUser=redisCache.getCacheObject(HttpEnum.redis_user+userId);


        if (Objects.isNull(loginUser)){
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }





        UsernamePasswordAuthenticationToken token1
                =new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(token1);

        chain.doFilter(request,response);
    }




}