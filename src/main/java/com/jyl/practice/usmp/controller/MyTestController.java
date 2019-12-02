package com.jyl.practice.usmp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyl.practice.usmp.aspect.annotation.ResponseBaseResult;
import com.jyl.practice.usmp.dao.SampleAnnotatedMapper;
import com.jyl.practice.usmp.po.SysUser;
import com.jyl.practice.usmp.service.SysUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @program: usmp
 * @description: 测试
 * @author: 19042501
 * @create: 2019-11-07 20:13
 */
@Log4j2
@RestController
public class MyTestController {

    @Autowired(required = false)
    private SampleAnnotatedMapper sampleAnnotatedMapper;

    @Autowired
    private SysUserService userService;

    @GetMapping("test/{name}")
    public String test(@PathVariable String name)
    {
        return "hello " + name;
    }

    @GetMapping("testDB")
    public LocalDateTime testDB()
    {
        return sampleAnnotatedMapper.test();
    }

    @GetMapping("testDB2")
    @ResponseBaseResult
    public String testDB2()
    {
        return sampleAnnotatedMapper.queryDemo().toString();
    }

    @GetMapping("testDB3/{name}")
    public String testDB3(@PathVariable String name)
    {
        SysUser user = new SysUser();
        user.setUserName(name);
        log.info("===123321===");
        return sampleAnnotatedMapper.queryDemo2(user).toString();
    }

    @GetMapping("testDB4")
    @ResponseBaseResult
    public Object testDB4(@RequestParam String name, @RequestParam String pwd)
    {
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(pwd);
        PageHelper.startPage(1,2);
        List<SysUser> userList =  sampleAnnotatedMapper.queryDemo2(user);
        return new PageInfo<>(userList);
    }

    @GetMapping("testPage1")
    public Object testPage1(@RequestParam String name, @RequestParam String pwd)
    {
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(pwd);
        return userService.queryUser(user);
    }

    @GetMapping("testPage2")
    public List<SysUser> testPage2(@RequestParam String name, @RequestParam String pwd)
    {
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(pwd);
        return userService.queryUser2(2,4, user);
    }

    @GetMapping("queryTest")
    public void inserTest1(@RequestParam String name, @RequestParam String pwd)
    {
        /*SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(pwd);
        userService.insertNoTrans(user);*/

        SysUser user = sampleAnnotatedMapper.queryUserByName(name, pwd);
        System.out.println(user);
    }

    @GetMapping("inserTest2")
    public void inserTest2(@RequestParam String name, @RequestParam String pwd)
    {
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(pwd);
        userService.insertTest(user);
    }

    @GetMapping("inserTest3")
    public void inserTest3(@RequestParam String name, @RequestParam String pwd)
    {
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(pwd);
        sampleAnnotatedMapper.addUser(user);
    }

    @RequestMapping("testDate")
    public void testDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime)
    {
        System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    @RequestMapping("testBean22")
    public void testBean22(@RequestBody SysUser user)
    {
        System.out.println(user);
    }




}
