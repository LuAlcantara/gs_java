package com.abrigo.service;

import com.abrigo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AbrigoConsumer {

    @RabbitListener(queues = RabbitMQConfig.NOME_FILA)
    public void receberMensagem(String mensagem) {
        System.out.println("[RabbitMQ] Recebido: " + mensagem);
    }
}
