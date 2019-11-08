package com.jyl.practice.usmp.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: usmp
 * @description: 自定义分页
 * @author: 19042501
 * @create: 2019-11-08 11:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CustomPageHelper {
    int page() default 1;
    int pageSize() default 3;
}
