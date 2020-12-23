package com.yjf.springboot_topic.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:16
 * @Description
 */
@Component
public class Customer {

    @RabbitListener(queues = "boot_topic_queue1")
    public void demo(Message message){
        System.out.println(new String(message.getBody()));
    }
}
