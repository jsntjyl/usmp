package com.jyl.practice.usmp.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @program: usmp
 * @description:
 * @author: 19042501
 * @create: 2019-11-07 21:11
 */
@Data
public class SysUser {
    private int id;

    private String userName;

    private String passWord;

    private String realName;

    /**
     * 指定格式优先级高于appconfig中的配置
     */
    //@JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private ZonedDateTime dateTime;
}
