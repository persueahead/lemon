package com.lemon.rabbitmq.simple;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] argv) throws Exception {
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        // �������д���ͨ��
        Channel channel = connection.createChannel();

        // ����������������(���֣��Ƿ�־û�����ռ��queue�� ��ʹ��ʱ�Ƿ��Զ�ɾ������������)
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // ��Ϣ����
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        //�ر�ͨ��������
        channel.close();
        connection.close();
    }
}