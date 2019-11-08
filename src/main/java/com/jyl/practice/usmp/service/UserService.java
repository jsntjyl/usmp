package com.jyl.practice.usmp.service;

import com.jyl.practice.usmp.aspect.annotation.CustomPageHelper;
import com.jyl.practice.usmp.dao.SampleAnnotatedMapper;
import com.jyl.practice.usmp.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: usmp
 * @description: test service
 * @author: 19042501
 * @create: 2019-11-08 11:12
 */
@Service
public class UserService {
    @Resource
    private SampleAnnotatedMapper sampleAnnotatedMapper;

    @CustomPageHelper
    public List<User> queryUser(User user)
    {
        return sampleAnnotatedMapper.queryDemo2(user);
    }

    @CustomPageHelper
    public List<User> queryUser2(int page, int pageSize, User user)
    {
        return sampleAnnotatedMapper.queryDemo2(user);
    }
}
