package com.lemon.rabbitmq.ps;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        String message = "后台系统中的商品数据改变了，商品的id为100";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("utf-8"));
        System.out.println("后台系统发送的消息为:" + message + "'");

        channel.close();
        connection.close();
    }
}