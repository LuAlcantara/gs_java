package com.abrigo.repository;

import com.abrigo.model.Abrigo;
import com.abrigo.model.CheckIn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CheckInRepositoryTest {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Test
    void deveSalvarCheckInComAbrigo() {
        Abrigo abrigo = new Abrigo();
        abrigo.setNome("Abrigo Central");
        abrigo.setEndereco("Rua Central, 456");
        abrigo.setRegiao("Centro");
        abrigo.setTemperatura(26);
        abrigo.setRecursos("água, comida");
        abrigo.setCapacidade(80);
        abrigo.setOcupacao(20);
        abrigo.setAtivo(true);
        abrigo.setResponsavel("Maria");
        abrigo.setTelefone("11988887777");

        abrigo = abrigoRepository.save(abrigo);

        CheckIn checkIn = new CheckIn();
        checkIn.setNome("Carlos");
        checkIn.setAbrigo(abrigo);

        checkInRepository.save(checkIn);

        List<CheckIn> checkins = checkInRepository.findAll();
        assertThat(checkins).isNotEmpty();
        assertThat(checkins.get(0).getNome()).isEqualTo("Carlos");
    }
}
