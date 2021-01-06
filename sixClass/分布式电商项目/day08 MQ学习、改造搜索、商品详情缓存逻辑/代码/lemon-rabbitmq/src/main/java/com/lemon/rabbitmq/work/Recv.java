package com.lemon.rabbitmq.work;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // ͬһʱ�̷�����ֻ�ᷢһ����Ϣ��������
        channel.basicQos(1);

        // ������е�������
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // �������У��ֶ��������
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // ��ȡ��Ϣ
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            //����
            Thread.sleep(10);
            // ����ȷ��״̬
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}