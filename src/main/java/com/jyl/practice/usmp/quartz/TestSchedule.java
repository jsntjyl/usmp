package com.jyl.practice.usmp.quartz;

import org.springframework.stereotype.Component;

@Component
public class TestSchedule {

    //@Scheduled(fixedDelay = 1000 * 10)
    public void test() {
        System.out.println("test scheduler is up and running");
    }
}
