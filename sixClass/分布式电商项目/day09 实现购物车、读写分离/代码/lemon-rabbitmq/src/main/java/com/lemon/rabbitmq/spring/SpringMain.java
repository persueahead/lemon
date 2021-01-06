package com.lemon.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:spring/rabbitmq-context.xml");
        //RabbitMQģ��
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        //������Ϣ
        template.convertAndSend("Hello, world!");
        Thread.sleep(1000);// ����1��
        ctx.destroy(); //��������
    }
}
