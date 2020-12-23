package com.yjf.demo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:02
 * @Description
 */
@SpringBootTest
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void demo(){
        rabbitTemplate.convertAndSend("boot_direct_exchange","red","boot red");

        rabbitTemplate.convertAndSend("boot_direct_exchange","green","boot green");
    }
}
