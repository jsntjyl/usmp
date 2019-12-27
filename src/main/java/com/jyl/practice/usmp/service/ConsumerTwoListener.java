package com.jyl.practice.usmp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: usmp
 * @description:
 * @author: 19042501
 * @create: 2019-12-13 10:45
 */
@Component
public class ConsumerTwoListener {

    @KafkaListener(topics = "testDemo")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println("two:" + message);
    }

}
