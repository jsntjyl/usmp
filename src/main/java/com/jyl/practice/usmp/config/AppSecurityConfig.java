package com.jyl.practice.usmp.config;

import com.jyl.practice.usmp.service.SysUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: usmp
 * @description: security 配置
 * @author: 19042501
 * @create: 2019-11-10 19:52
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SysUserDetailsService sysUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // 表单认证
                .formLogin()
                // 登录页
                //.loginPage("/login")
                // 登录表单提交地址
                .loginProcessingUrl("/auth/login")
                .and()
                // 身份认证请求
                .authorizeRequests()
                // 任何人都可以访问
                .antMatchers("/**").permitAll()
                //持有相应权限的用户可以访问，role可以有两种写法
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/user/**").hasAuthority("ROLE_USER")
                .and()
                .rememberMe()
                .rememberMeCookieName("usmp_remember_me")
                .rememberMeParameter("remember_me")
                .tokenValiditySeconds(86400)
                //.anyRequest()
                // 任意请求
                // 身份认证
                //.authenticated()
        ;

    }

    /**
     * 配置 用户明细
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserDetailsService);
    }
}
