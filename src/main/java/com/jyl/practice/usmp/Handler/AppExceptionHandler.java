package com.jyl.practice.usmp.Handler;

import com.jyl.practice.usmp.exception.UsmpAppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public ErrorMessage handAppException(UsmpAppException e, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode("");
        errorMessage.setMessage("");
        errorMessage.setExcetionMsg(e.getMessage());
        errorMessage.setPath(getPath(request));
        errorMessage.setTimestamp(ZonedDateTime.now());
        return new ErrorMessage();
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
