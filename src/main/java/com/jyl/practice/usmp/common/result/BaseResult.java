package com.jyl.practice.usmp.common.result;

import com.jyl.practice.usmp.common.enums.ResultCodeEnum;
import lombok.*;

import java.io.Serializable;

/**
 * @program: usmp
 * @description: result类
 * @author: 19042501
 * @create: 2019-11-08 20:14
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1362838593009498450L;
    private String code;
    private String message;
    private Object data;

    public static class BaseResultBuilder
    {
        private String code;
        private String message;
        private Object data;

        public BaseResultBuilder addCode(String code)
        {
           this.code = code;
           return this;
        }

        public BaseResultBuilder addMessage(String message)
        {
            this.message = message;
            return this;
        }

        public BaseResultBuilder addData(Object data)
        {
            this.data = data;
            return this;
        }

        public BaseResultBuilder addResultEnum(ResultCodeEnum resultCodeEnum)
        {
            this.code = resultCodeEnum.getCode();
            this.message = resultCodeEnum.getMessage();
            return this;
        }

        public BaseResult buildResult()
        {
            return new BaseResult(this.code, this.message, this.data);
        }
    }
}
