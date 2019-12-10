package com.jyl.practice.usmp.service;

import com.jyl.practice.usmp.dao.SampleAnnotatedMapper;
import com.jyl.practice.usmp.po.SysUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: usmp
 * @description: 系统用户
 * @author: 19042501
 * @create: 2019-11-10 20:10
 */
@Service
public class SysUserDetailsService implements UserDetailsService {

    @Resource
    private SampleAnnotatedMapper sampleAnnotatedMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        SysUser sysUser = sampleAnnotatedMapper.queryUserByName(userName);
        User user = new User(sysUser.getUserName(), passwordEncoder.encode(sysUser.getPassWord()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        return user;
    }
}
