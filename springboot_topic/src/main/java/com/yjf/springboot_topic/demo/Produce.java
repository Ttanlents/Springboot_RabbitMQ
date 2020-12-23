package com.yjf.springboot_topic.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:14
 * @Description
 */
@SpringBootTest
public class Produce {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void demo(){
       rabbitTemplate.convertAndSend("boot_topic_exchange","red.green.green","topic..........");
    }
}
