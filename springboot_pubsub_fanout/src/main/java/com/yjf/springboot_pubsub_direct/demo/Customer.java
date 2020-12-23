package com.yjf.springboot_pubsub_direct.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 余俊锋
 * @date 2020/12/23 15:50
 * @Description
 */
@Component
public class Customer {

    @RabbitListener(queues = "boot_fanout_queue1")
    public void listener1(Message message){
        System.out.println("我的queue1"+new String(message.getBody()));
    }

    @RabbitListener(queues = "boot_fanout_queue2")
    public void listener2(Message message){
        System.out.println("我的queue2"+new String(message.getBody()));
    }
}
