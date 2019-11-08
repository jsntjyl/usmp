package com.jyl.practice.usmp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyl.practice.usmp.aspect.annotation.CustomPageHelper;
import com.jyl.practice.usmp.dao.SampleAnnotatedMapper;
import com.jyl.practice.usmp.po.User;
import com.jyl.practice.usmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/**
 * @program: usmp
 * @description: 测试
 * @author: 19042501
 * @create: 2019-11-07 20:13
 */
@RestController
public class MyTestController {

    @Autowired(required = false)
    private SampleAnnotatedMapper sampleAnnotatedMapper;

    @Autowired
    private UserService userService;

    @GetMapping("test/{name}")
    public String test(@PathVariable String name)
    {
        return "hello " + name;
    }

    @GetMapping("testDB")
    public Object testDB()
    {
        return sampleAnnotatedMapper.test().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @GetMapping("testDB2")
    public String testDB2()
    {
        return sampleAnnotatedMapper.queryDemo().toString();
    }

    @GetMapping("testDB3/{name}")
    public String testDB3(@PathVariable String name)
    {
        User user = new User();
        user.setUserName(name);
        return sampleAnnotatedMapper.queryDemo2(user).toString();
    }

    @GetMapping("testDB4")
    public Object testDB4(@RequestParam String name, @RequestParam String pwd)
    {
        User user = new User();
        user.setUserName(name);
        user.setPassWord(pwd);
        PageHelper.startPage(1,2);
        List<User> userList =  sampleAnnotatedMapper.queryDemo2(user);
        return new PageInfo<>(userList);
    }

    @GetMapping("testPage1")
    public Object testPage1(@RequestParam String name, @RequestParam String pwd)
    {
        User user = new User();
        user.setUserName(name);
        user.setPassWord(pwd);
        return userService.queryUser(user);
    }

    @GetMapping("testPage2")
    public Object testPage2(@RequestParam String name, @RequestParam String pwd)
    {
        User user = new User();
        user.setUserName(name);
        user.setPassWord(pwd);
        return userService.queryUser2(2,4, user);
    }
}
