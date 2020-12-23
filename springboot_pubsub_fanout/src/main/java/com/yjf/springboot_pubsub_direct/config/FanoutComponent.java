package com.yjf.springboot_pubsub_direct.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 余俊锋
 * @date 2020/12/23 15:40
 * @Description
 */
@Configuration
public class FanoutComponent {

    @Bean("bootFanoutQueue1")
    public Queue queue1(){
        //return new Queue("",true,false,false,null);
    return QueueBuilder.durable("boot_fanout_queue1").build();
    }

    @Bean("bootFanoutQueue2")
    public Queue queue2(){
        //return new Queue("",true,false,false,null);
        return QueueBuilder.durable("boot_fanout_queue2").build();
    }

    // fanout类型交换机
    @Bean("bootFanoutExchange")
    public Exchange bootFanoutExchange(){
        return ExchangeBuilder.fanoutExchange("boot_fanout_exchange").durable(true).build();
    }

    /**
     * 交换机与队列进行绑定
     */
    @Bean
    public Binding bindFanout1(){

        Queue bootFanoutQueue1 = queue1();
        Exchange bootFanoutExchange = bootFanoutExchange();

        // fanout类型交换机routing key为 ""
        return BindingBuilder.bind(bootFanoutQueue1).to(bootFanoutExchange).with("").noargs();
    }

    /**
     * 交换机与队列进行绑定
     * @return
     */
    @Bean
    public Binding bindFanout2(){
        Queue bootFanoutQueue2 = queue2();
        Exchange bootFanoutExchange = bootFanoutExchange();

        return BindingBuilder.bind(bootFanoutQueue2).to(bootFanoutExchange).with("").noargs();
    }

}
