package com.yjf.springboot_work_simple.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Config_01_Work {

    /**
     * 定义一个队列
     * @return
     */
    @Bean("bootWorkQueue")
    public Queue bootWorkQueue() {
        /*
            第一种方式:
                durable():代表需要持久化
                exclusive(): 代表该队列独占(只允许有一个consumer监听)
                autoDelete(): 代表需要自动删除(没有consumer自动删除)
                withArgument(): 队列的其他参数


    return QueueBuilder.durable("boot_work_queue").exclusive().autoDelete().withArgument("key", "val").build();

            第二种方式:
                通过new Queue对象来创建队列
                参数1: 队列名称
                参数2: 是否持久化(默认:true)
                参数3: 是否独占(默认:false)
                参数4: 是否自动删除(默认:false)
                参数5: 队列的其他参数
         */
        return new Queue("boot_work_queue", true, false, false,null);
        //return QueueBuilder.durable("boot_work_queue").exclusive().autoDelete().withArgument("key", "val").build();
    }
}