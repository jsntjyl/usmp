package com.jyl.practice.usmp.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: usmp
 * @description: 自定义异常
 * @author: 19042501
 * @create: 2019-11-08 16:01
 */
@Getter
@Setter
public class UsmpAppException extends RuntimeException {
    private String code;
    private String message;

    public UsmpAppException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
