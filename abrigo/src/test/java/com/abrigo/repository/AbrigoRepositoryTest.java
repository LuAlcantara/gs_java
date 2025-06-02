package com.abrigo.repository;

import com.abrigo.model.Abrigo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AbrigoRepositoryTest {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Test
    void deveSalvarEAbrigoNoBanco() {
        Abrigo abrigo = new Abrigo();
        abrigo.setNome("Abrigo Teste");
        abrigo.setEndereco("Rua Exemplo, 123");
        abrigo.setRegiao("Centro");
        abrigo.setTemperatura(27);
        abrigo.setRecursos("água, comida, roupas");
        abrigo.setCapacidade(100);
        abrigo.setOcupacao(50);
        abrigo.setAtivo(true);
        abrigo.setResponsavel("João da Silva");
        abrigo.setTelefone("11999999999");

        abrigoRepository.save(abrigo);

        List<Abrigo> abrigos = abrigoRepository.findAll();
        assertThat(abrigos).isNotEmpty();
        assertThat(abrigos.get(0).getNome()).isEqualTo("Abrigo Teste");
    }
}
