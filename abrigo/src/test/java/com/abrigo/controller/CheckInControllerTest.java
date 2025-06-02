package com.abrigo.controller;

import com.abrigo.model.CheckIn;
import com.abrigo.repository.AbrigoRepository;
import com.abrigo.repository.CheckInRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CheckInController.class)
class CheckInControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CheckInRepository checkInRepository;

    @MockBean
    private AbrigoRepository abrigoRepository;

    @WithMockUser
    @Test
    void deveExibirListaDeCheckins() throws Exception {
        CheckIn checkIn = new CheckIn();

        // Crie um abrigo com nome preenchido
        var abrigo = new com.abrigo.model.Abrigo();
        abrigo.setNome("Abrigo Teste");

        // Associe o abrigo ao check-in
        checkIn.setAbrigo(abrigo);

        when(checkInRepository.findAll()).thenReturn(Collections.singletonList(checkIn));

        mockMvc.perform(get("/checkins"))
                .andExpect(status().isOk())
                .andExpect(view().name("abrigos/checkins"))
                .andExpect(model().attributeExists("checkins"));
    }
}
