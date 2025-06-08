package com.abrigo.controller;

import com.abrigo.model.Abrigo;
import com.abrigo.service.AbrigoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("abrigos", abrigoService.listarTodos());
        return "abrigos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("abrigo", new Abrigo());
        return "abrigos/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Abrigo abrigo, BindingResult result) {
        if (result.hasErrors()) {
            return "abrigos/form";
        }

        if (abrigo.getId() != null) {
            Optional<Abrigo> existente = abrigoService.buscarPorId(abrigo.getId());
            if (existente.isPresent()) {
                Abrigo atual = existente.get();
                atual.setNome(abrigo.getNome());
                atual.setEndereco(abrigo.getEndereco());
                atual.setRegiao(abrigo.getRegiao());
                atual.setTemperatura(abrigo.getTemperatura());
                atual.setRecursos(abrigo.getRecursos());
                atual.setCapacidade(abrigo.getCapacidade());
                atual.setOcupacao(abrigo.getOcupacao());
                atual.setAtivo(abrigo.isAtivo());
                atual.setResponsavel(abrigo.getResponsavel());
                atual.setTelefone(abrigo.getTelefone());
                abrigoService.salvar(atual);
                return "redirect:/abrigos";
            }
        }

        abrigoService.salvar(abrigo); // novo cadastro
        return "redirect:/abrigos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Abrigo> abrigo = abrigoService.buscarPorId(id);
        if (abrigo.isPresent()) {
            model.addAttribute("abrigo", abrigo.get());
            return "abrigos/form";
        } else {
            return "redirect:/abrigos";
        }
    }

    @GetMapping("/checkin")
    public String checkin(Model model) {
        model.addAttribute("checkIn", new com.abrigo.model.CheckIn());
        model.addAttribute("abrigos", abrigoService.listarTodos());
        return "abrigos/checkin";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        abrigoService.excluir(id);
        return "redirect:/abrigos";
    }
}
