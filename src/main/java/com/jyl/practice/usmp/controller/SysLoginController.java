package com.jyl.practice.usmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: usmp
 * @description: 登录控制类
 * @author: 19042501
 * @create: 2019-11-10 20:05
 */
@Controller
public class SysLoginController {

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping("/index")
    public String indexPage()
    {
        return "index";
    }
}
