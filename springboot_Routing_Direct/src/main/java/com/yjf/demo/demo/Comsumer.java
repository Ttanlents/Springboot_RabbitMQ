package com.yjf.demo.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:04
 * @Description
 */
@Component
public class Comsumer {


    @RabbitListener(queues = "boot_direct_queue1")
    public void listener1(Message message){
        System.out.println("我的queue1"+new String(message.getBody()));
    }

    @RabbitListener(queues = "boot_direct_queue2")
    public void listener2(Message message){
        System.out.println("我的queue2"+new String(message.getBody()));
    }
}
