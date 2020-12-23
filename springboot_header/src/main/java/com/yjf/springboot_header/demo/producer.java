package com.yjf.springboot_header.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:22
 * @Description
 */
@SpringBootTest
public class producer {
    @Autowired
    RabbitMessagingTemplate rabbitMessagingTemplate;

    @Test
    public void demo(){
        // 准备header参数
        Map<String, Object> headers = new HashMap<>();
        headers.put("key1", "147");
        headers.put("key2", "258");
        headers.put("key3", "369");
        rabbitMessagingTemplate.convertAndSend("boot_header_exchange","","this is this message",headers);
    }

}
