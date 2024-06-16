package cn.wenzhuo4657.blog.basic.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
@Configurable
public class SpringSercrityConfig extends WebSecurityConfigurerAdapter {


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

    }


}