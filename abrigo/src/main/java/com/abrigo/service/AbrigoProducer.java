package com.abrigo.service;

import com.abrigo.config.RabbitMQConfig;
import com.abrigo.model.Abrigo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbrigoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarMensagem(Abrigo abrigo) {
        String mensagem = "Novo abrigo cadastrado: " + abrigo.getNome();
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOME_FILA, mensagem);
        System.out.println("[RabbitMQ] Enviado: " + mensagem);
    }
}
