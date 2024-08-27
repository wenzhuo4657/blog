package cn.wenzhuo4657.blog.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @className: SecurityConifg
 * @author: wenzhuo4657
 * @date: 2024/8/27 10:44
 * @Version: 1.0
 * @description:
 */

@Configuration
@Profile("security-admin")
public class SecurityConifg extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}