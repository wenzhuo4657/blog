package cn.wenzhuo4657.blog.basic.config;

import cn.wenzhuo4657.blog.basic.Filter.SpringSecurity.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @className: SpringSercrity
 * @author: wenzhuo4657
 * @date: 2024/6/16 15:05
 * @Version: 1.0
 * @description:
 */
@Configuration
public class SercrityConfig extends WebSecurityConfigurerAdapter {


    @Bean( name="authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Autowired
    private JwtAuthenticationTokenFilter TOKENfilter;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected  void configure(HttpSecurity http)throws  Exception{
        http.
                csrf().disable()
//        Spring Security 永远不会创建HttpSession ，也永远不会使用它来获取SecurityContext
//                使用token来进行管理
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                        .antMatchers("/login").anonymous();

        //允许跨域:
        //  wenzhuo TODO 2024/6/16 :可尝试使用nginx解决
        http.cors();


//        加入jwt过滤器
        http.addFilterBefore(TOKENfilter, UsernamePasswordAuthenticationFilter.class);

    }
}