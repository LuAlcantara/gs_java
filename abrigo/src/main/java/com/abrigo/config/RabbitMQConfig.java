package com.abrigo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String NOME_FILA = "fila-abrigos";

    @Bean
    public Queue queue() {
        return new Queue(NOME_FILA, false); // false = fila não persistente
    }
}
