package com.yjf.springboot_topic.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余俊锋
 * @date 2020/12/23 16:12
 * @Description
 */
@Configuration
public class TopicConfig {
    @Bean("bootTopicQueue1")
    public Queue bootTopicQueue1(){
        return QueueBuilder.durable("boot_topic_queue1").build();
    }

    @Bean("bootTopicQueue2")
    public Queue bootTopicQueue2(){
        return QueueBuilder.durable("boot_topic_queue2").build();
    }

    // topic类型交换机
    @Bean("bootTopicExchange")
    public Exchange bootTopicExchange(){

        return ExchangeBuilder.topicExchange("boot_topic_exchange").durable(true).build();
    }

    /**
     * 交换机与队列进行绑定
     */
    @Bean
    public Binding bindTopic1(){

        Queue bootTopicQueue1 = bootTopicQueue1();
        Exchange bootTopicExchange = bootTopicExchange();

        return BindingBuilder.bind(bootTopicQueue1).to(bootTopicExchange).with("red.#").noargs();
    }

    /**
     * 交换机与队列进行绑定
     * @return
     */
    @Bean
    public Binding bindTopic2(){
        Queue bootTopicQueue2 = bootTopicQueue2();
        Exchange bootTopicExchange = bootTopicExchange();
        return BindingBuilder.bind(bootTopicQueue2).to(bootTopicExchange).with("green.*").noargs();
    }
}
