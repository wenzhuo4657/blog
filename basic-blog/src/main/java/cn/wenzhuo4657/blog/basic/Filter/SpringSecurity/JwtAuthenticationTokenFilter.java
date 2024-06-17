package cn.wenzhuo4657.blog.basic.Filter.SpringSecurity;


import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import cn.wenzhuo4657.blog.basic.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @className: JwtAuthenticationToken
 * @author: wenzhuo4657
 * @date: 2024/6/17 14:50
 * @Version: 1.0
 * @description:  token验证，
 * 这里需要将其作为springSecurity过滤器链的第一个过滤器，其实际含义为：
 * 如果存在token,则将其认证交给java程序处理，也就是说替代了loadUserByUsername方法，
 */
@Component
public class JwtAuthenticationTokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = (String)request.getAttribute("token");
        if (!StringUtils.hasText(token)){
            chain.doFilter(request,response);
            return;
        }
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userid=claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //  wenzhuo TODO 2024/6/17 : 根据userid从redis中获取缓存



        UsernamePasswordAuthenticationToken authenticationToken
                =null;
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }
}