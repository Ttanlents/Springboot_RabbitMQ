package com.yjf.springboot_header.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:22
 * @Description
 */
@Configuration
public class ConfigHeader {

    // 声明一个queue
    @Bean("bootHeaderQueue")
    public Queue bootHeaderQueue(){
        return QueueBuilder.durable("boot_header_queue").build();
    }

    // header类型交换机
    @Bean("bootHeaderExchange")
    public Exchange bootHeaderExchange(){

        return ExchangeBuilder.headersExchange("boot_header_exchange").durable(true).build();
    }

    // 将exchange和queue进行绑定
    @Bean
    public Binding bindHeader(){

        Queue queue = bootHeaderQueue();
        Exchange exchange = bootHeaderExchange();

        Map<String, Object> headers = new HashMap<>();
        /*
            all:Producer必须匹配所有的键值对
            any:只要Producer匹配任意一个键值对即可
         */
        headers.put("x-match", "any");
        headers.put("key1", "147");
        headers.put("key2", "258");
        headers.put("key3", "369");

        // routing key 为空
        return BindingBuilder.bind(queue).to(exchange).with("").and(headers);
    }
}
