package com.jyl.practice.usmp.Handler;

import com.jyl.practice.usmp.aspect.annotation.ResponseBaseResult;
import com.jyl.practice.usmp.common.enums.ResultCodeEnum;
import com.jyl.practice.usmp.common.result.BaseResult;
import com.jyl.practice.usmp.common.result.BaseResult.BaseResultBuilder;
import com.jyl.practice.usmp.Handler.AppExceptionHandler.ErrorMessage;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @program: usmp
 * @description: 响应体处理类
 * @author: 19042501
 * @create: 2019-11-08 14:08
 */
@ControllerAdvice
@Component
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    /**
     * 是否做响应增强的判断
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method = methodParameter.getMethod();
        return method.isAnnotationPresent(ResponseBaseResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        BaseResultBuilder baseResultBuilder = new BaseResultBuilder();
        BaseResult result;
        if (o instanceof ErrorMessage)
        {
            result = baseResultBuilder.addCode(((ErrorMessage) o).getCode()).addMessage(((ErrorMessage) o).getMessage()).buildResult();
            return result;
        }
        result = baseResultBuilder.addResultEnum(ResultCodeEnum.SUCCESS).addData(o).buildResult();
        return result;
    }
}
