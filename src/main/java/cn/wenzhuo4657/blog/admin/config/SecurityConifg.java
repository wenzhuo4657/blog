package cn.wenzhuo4657.blog.admin.config;


import cn.wenzhuo4657.blog.admin.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @className: SecurityConifg
 * @author: wenzhuo4657
 * @date: 2024/8/27 10:44
 * @Version: 1.0
 * @description:
 */

@Configuration
@Profile("security-admin")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConifg extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
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
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**", "/api/v2/api-docs").permitAll()
                .antMatchers("/user/login").anonymous()
                .antMatchers("/user/logout").authenticated()
                .anyRequest().permitAll();

        http.cors();
        http.logout().disable();
        http.addFilterBefore(TOKENfilter, UsernamePasswordAuthenticationFilter.class);




    }
}