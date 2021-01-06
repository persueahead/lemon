package com.lemon.rabbitmq.routing;


import com.lemon.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

    private final static String QUEUE_NAME = "test_queue1_direct";

    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] argv) throws Exception {
    	//ǰ̨ϵͳ
        // ��ȡ�������Լ�mqͨ��
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // ��������
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // �󶨶��е�������
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");

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
            System.out.println("ǰ̨ϵͳ��ȡ������ϢΪ" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}