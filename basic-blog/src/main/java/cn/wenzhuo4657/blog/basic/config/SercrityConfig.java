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
                .antMatchers("/login").anonymous()
                .antMatchers("/logout").authenticated()
                .anyRequest().permitAll();
        //注意permitall()是允许所有用户访问，不会设置匿名的 Authentication 对象
//        anonymous()该限制下的所有接口当成匿名用户去访问，对于每一个匿名用户都会自动创建一个AnonymousAuthenticationToken 来代表该用户
//        简单来说这两者区别就是permitall允许任何人访问，且不会对这些访问者追踪，但是anonymous()会对这些访问者设置标记，也就是AnonymousAuthenticationToken，
//           authenticated()表示经过身份验证，也就是所设置的过滤器，同样也是anonymous()中某些通过验证的访问者


        //允许跨域:
        //  wenzhuo TODO 2024/6/16 :可尝试使用nginx解决
        http.cors();


        http.logout().disable();


//        加入jwt过滤器
        http.addFilterBefore(TOKENfilter, UsernamePasswordAuthenticationFilter.class);

    }
}