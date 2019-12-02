package com.jyl.practice.usmp.Handler;

import com.jyl.practice.usmp.aspect.annotation.ResponseBaseResult;
import com.jyl.practice.usmp.common.enums.ResultCodeEnum;
import com.jyl.practice.usmp.common.exception.UsmpAppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

/**
 * @program: usmp
 * @description: 异常处理
 * @author: 19042501
 * @create: 2019-11-08 15:46
 */
@ControllerAdvice
public class AppExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(UsmpAppException.class)
    @ResponseBody
    public Object handAppException(UsmpAppException e, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(e.getCode());
        errorMessage.setMessage(e.getMessage());
        errorMessage.setExcetionMsg(e.getMessage());
        errorMessage.setPath(getPath(request));
        errorMessage.setTimestamp(ZonedDateTime.now());

        logger.error("application catch exception, message : {}", errorMessage, e);
        return errorMessage;
    }

    /**
     *
     * @param e
     * @param request
     * @return 默认返回是统一错误页面，加上responsebody代表返回消息内容
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object handRuntimeException(RuntimeException e, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(getCode(request));
        errorMessage.setMessage("application is error");
        errorMessage.setExcetionMsg(e.getMessage());
        errorMessage.setPath(getPath(request));
        errorMessage.setTimestamp(ZonedDateTime.now());
        logger.error("application catch exception, message : {}", errorMessage, e);
        return errorMessage;
    }

    private Object getAttribute(RequestAttributes requestAttributes, String name) {
        return requestAttributes.getAttribute(name, 0);
    }

    private String getPath(final WebRequest request) {
        String path = (String)this.getAttribute(request, "javax.servlet.error.request_uri");

        if (path == null) {
            path = ((ServletWebRequest) request).getRequest().getServletPath();
        }

        return path;
    }

    private String getCode(final WebRequest request) {
        String code = (String)this.getAttribute(request, "javax.servlet.error.status_code");

        return code == null ? ResultCodeEnum.SYSTEM_ERROR.getCode() : code;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class ErrorMessage
    {
        private String code;
        private String message;
        private String path;
        private String excetionMsg;
        private ZonedDateTime timestamp;
    }
}
