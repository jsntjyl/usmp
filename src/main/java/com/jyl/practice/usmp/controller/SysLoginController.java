package com.jyl.practice.usmp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: usmp
 * @description: 登录控制类
 * @author: 19042501
 * @create: 2019-11-10 20:05
 */
@Controller
public class SysLoginController {

    /**
     * 获取当前用户信息
     * @param authentication
     * @return
     */
    @GetMapping("/info")
    @ResponseBody
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }
}
