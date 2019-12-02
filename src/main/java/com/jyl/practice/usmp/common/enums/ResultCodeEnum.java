package com.jyl.practice.usmp.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: usmp
 * @description: 响应结果枚举
 * @author: 19042501
 * @create: 2019-11-09 09:56
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    /**系统异常**/
    SYSTEM_ERROR("9999", "system error"),
    SUCCESS("0000", "success")
    ;
    private String code;
    private String message;
}
