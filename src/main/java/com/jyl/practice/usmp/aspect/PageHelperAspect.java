package com.jyl.practice.usmp.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyl.practice.usmp.aspect.annotation.CustomPageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @program: usmp
 * @description: 分页统一处理
 * @author: 19042501
 * @create: 2019-11-08 10:58
 */
@Aspect
@Component
public class PageHelperAspect {

    /**
     * 按方法上的入参进行分页查询，否则按默认值进行查询
     * 参数名：page 、pageSize
     * @param customPageHelper
     * @throws Throwable
     */
    @Around(value = "@annotation(customPageHelper)")
    public Object doAround(ProceedingJoinPoint joinPoint, CustomPageHelper customPageHelper) throws Throwable {
        // 初始化参数,默认查所有
        int page = customPageHelper.page();
        int pageSize = customPageHelper.pageSize();
        // 获得当前访问的class
        Class<?> className = joinPoint.getTarget().getClass();
        // 获得访问的方法名
        String methodName = joinPoint.getSignature().getName();
        // 得到方法的参数的类型
        Class<?>[] argClass = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 得到方法的参数的类型
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        // 获取参数 page 和 pageSize
        Object[] args = joinPoint.getArgs();
        int i = 0;
        for (String pName : parameterNames) {
            if (pName.equals("page")) {
                page = (int) args[i];
            }
            if (pName.equals("pageSize")) {
                pageSize = (int) args[i];
            }
            i++;
        }
        // 设置分页
        PageHelper.startPage(page, pageSize);

        return joinPoint.proceed();
    }
}
