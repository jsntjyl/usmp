package com.jyl.practice.usmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jyl.practice.usmp.dao")
@SpringBootApplication
public class UsmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsmpApplication.class, args);
    }

}
