package com.lemon.rabbitmq.topic;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // ����exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // ��Ϣ����
        String message = "ɾ�������ˣ���Ʒ��id��100";
        channel.basicPublish(EXCHANGE_NAME, "item.delete", null, message.getBytes());
        System.out.println("��̨ϵͳ������Ϣ��" + message + "'");

        channel.close();
        connection.close();
    }
}