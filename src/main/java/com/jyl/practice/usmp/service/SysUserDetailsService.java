package com.jyl.practice.usmp.service;

import com.jyl.practice.usmp.dao.SampleAnnotatedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //sampleAnnotatedMapper.queryUserByName(userName);
        User user = new User("", "", AuthorityUtils.commaSeparatedStringToAuthorityList(""));
        return null;
    }
}
