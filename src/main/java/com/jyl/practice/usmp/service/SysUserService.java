package com.jyl.practice.usmp.service;

import com.jyl.practice.usmp.aspect.annotation.CustomPageHelper;
import com.jyl.practice.usmp.dao.SampleAnnotatedMapper;
import com.jyl.practice.usmp.po.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: usmp
 * @description: test service
 * @author: 19042501
 * @create: 2019-11-08 11:12
 */
@Service
public class SysUserService {
    @Resource
    private SampleAnnotatedMapper sampleAnnotatedMapper;

    @CustomPageHelper
    public List<SysUser> queryUser(SysUser user)
    {
        return sampleAnnotatedMapper.queryDemo2(user);
    }

    @CustomPageHelper
    public List<SysUser> queryUser2(int page, int pageSize, SysUser user)
    {
        return sampleAnnotatedMapper.queryDemo2(user);
    }

    @Transactional
    public void insertTest(SysUser user)
    {
        sampleAnnotatedMapper.addUser(user);
        sampleAnnotatedMapper.addUser(user);
        throw new RuntimeException();
    }

    public void insertNoTrans(SysUser user)
    {
        sampleAnnotatedMapper.addUser(user);
        sampleAnnotatedMapper.addUser(user);
        throw new RuntimeException();
    }
}
