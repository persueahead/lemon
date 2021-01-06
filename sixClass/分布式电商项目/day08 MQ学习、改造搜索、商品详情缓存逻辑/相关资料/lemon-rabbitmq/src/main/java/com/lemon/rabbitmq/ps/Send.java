package com.lemon.rabbitmq.ps;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // ����exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // ��Ϣ����
        String message = "��̨ϵͳ�е���Ʒ���ݸı��ˣ���Ʒ��idΪ100";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("utf-8"));
        System.out.println("��̨ϵͳ���͵���ϢΪ:" + message + "'");

        channel.close();
        connection.close();
    }
}