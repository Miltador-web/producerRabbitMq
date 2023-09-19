package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Main {
    private final static String QUEUE_NAME = "minha-fila";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // Endereço do servidor RabbitMQ

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String mensagem = "Tudo vxcvvcsvx? -----?";
            channel.basicPublish("", QUEUE_NAME, null, mensagem.getBytes());
            System.out.println("Mensagem enviada: " + mensagem);
        }
    }
}