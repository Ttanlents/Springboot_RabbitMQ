package com.yjf.springboot_work_simple.demo;

import com.yjf.springboot_work_simple.SpringbootWorkSimpleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 余俊锋
 * @date 2020/12/23 15:30
 * @Description
 */
@SpringBootTest(classes = SpringbootWorkSimpleApplication.class)
public class ProductTest {
   @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public  void demo(){
        rabbitTemplate.convertAndSend("","boot_work_queue","demo work simple");
    }
}
