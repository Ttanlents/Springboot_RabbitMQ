package com.yjf.springboot_work_simple.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 余俊锋
 * @date 2020/12/23 15:34
 * @Description
 */
@Component
@RabbitListener(queues = "boot_work_queue")
public class Comsumer {
    @RabbitHandler
    public void receive(String str) {
        System.out.println(str);
    }
}
