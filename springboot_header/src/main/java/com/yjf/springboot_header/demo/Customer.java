package com.yjf.springboot_header.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:23
 * @Description
 */
@Component
public class Customer {

    @RabbitListener(queues = "boot_header_queue")
    public void getMessage(Message message){
        System.out.println(new String(message.getBody()));
    }

}
