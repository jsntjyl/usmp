package com.jyl.practice.usmp.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: usmp
 * @description:
 * @author: 19042501
 * @create: 2019-11-07 21:11
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private int id;

    private String userName;

    private String passWord;

    private String realName;
}
