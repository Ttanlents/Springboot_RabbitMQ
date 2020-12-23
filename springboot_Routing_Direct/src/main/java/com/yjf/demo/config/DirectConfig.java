package com.yjf.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余俊锋
 * @date 2020/12/23 15:58
 * @Description
 */
@Configuration
public class DirectConfig {

    /**
     * 准备两个队列boot_direct_queue1、boot_direct_queue2
     * @return
     */
    @Bean("bootDirectQueue1")
    public Queue bootDirectQueue1(){
        return QueueBuilder.durable("boot_direct_queue1").build();
    }

    @Bean("bootDirectQueue2")
    public Queue bootDirectQueue2(){
        return QueueBuilder.durable("boot_direct_queue2").build();
    }

    // direct类型交换机
    @Bean("bootDirectExchange")
    public Exchange bootDirectExchange(){
        /*
            第一种方式: 通过ExchangeBuilder构建交换机
                durable: 是否持久化
                autoDelete: 是否自动删除
                withArgument: 交换机其他参数
         */
//        return ExchangeBuilder.directExchange("boot_direct_exchange").durable(true).autoDelete().withArgument("key","val").build();

        /*
            第二种方式:
                参数1: 是否持久化(默认false)
                参数2: 是否自动删除(默认false)
                参数3: 其他参数
         */
        return new DirectExchange("boot_direct_exchange",true,false,null);
    }

    /**
     * 交换机与队列进行绑定
     */
    @Bean
    public Binding bindDirect1(){

        Queue bootDirectQueue1 = bootDirectQueue1();
        Exchange bootDirectExchange = bootDirectExchange();


        /*
            第一种方式:
                bind(Queue): 需要绑定的queue
                to(Exchange): 需要绑定到哪个交换机
                with(String): routing key
                noargs(): 进行构建
         */
//        return BindingBuilder.bind(bootDirectQueue1).to(bootDirectExchange).with("article").noargs();

        /*
            第一种方式:
                参数1: 绑定的队列
                参数2: 绑定的类型 Binding.DestinationType.QUEUE: 绑定的类型为queue(交换机不仅可以绑定queue还可以绑定exchange)
                参数3: 哪个交换机需要绑定
                参数4: routing key
                参数5: 其他参数
         */
        return new Binding("boot_direct_queue1", Binding.DestinationType.QUEUE,"boot_direct_exchange","red",null);
    }

    /**
     * 交换机与队列进行绑定
     * @return
     */
    @Bean
    public Binding bindDirect2(){
        Queue bootDirectQueue2 = bootDirectQueue2();
        Exchange bootDirectExchange = bootDirectExchange();

        return BindingBuilder.bind(bootDirectQueue2).to(bootDirectExchange).with("green").noargs();
    }
}
