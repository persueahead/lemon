package com.lemon.rabbitmq.routing;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // ����exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // ��Ϣ����
        String message = "��������Ʒ����Ʒ��idΪ100";
        channel.basicPublish(EXCHANGE_NAME, "update", null, message.getBytes("gbk"));
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}