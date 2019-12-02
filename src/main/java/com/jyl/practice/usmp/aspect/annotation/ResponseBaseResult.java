package com.jyl.practice.usmp.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: usmp
 * @description: 响应统一结果
 * @author: 19042501
 * @create: 2019-11-09 10:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ResponseBaseResult {
}
