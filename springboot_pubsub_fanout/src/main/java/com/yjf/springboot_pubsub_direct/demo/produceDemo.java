package com.yjf.springboot_pubsub_direct.demo;

import com.yjf.springboot_pubsub_direct.SpringbootPubsubDirectApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 余俊锋
 * @date 2020/12/23 15:47
 * @Description
 */
@SpringBootTest(classes = SpringbootPubsubDirectApplication.class)
public class produceDemo {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void produce(){
        rabbitTemplate.convertAndSend("boot_fanout_exchange","","boot fanout");
    }
}
