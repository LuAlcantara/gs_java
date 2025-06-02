package com.abrigo.service;

import com.abrigo.model.Abrigo;
import com.abrigo.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private AbrigoProducer produtor;

    @Autowired
    private OpenAiService openAiService;

    public List<Abrigo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Abrigo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Abrigo salvar(Abrigo abrigo) {
        Abrigo salvo = repository.save(abrigo);

        // Envia mensagem ao RabbitMQ
        produtor.enviarMensagem(salvo);

        // Gera alerta com IA
        String alerta = openAiService.gerarAlerta(salvo.getNome(), salvo.getCapacidade(), 92); // simula ocupação
        System.out.println("[OpenAI] Alerta: " + alerta);

        return salvo;
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
