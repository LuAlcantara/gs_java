package com.abrigo.controller;

import com.abrigo.model.Abrigo;
import com.abrigo.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("abrigos", abrigoRepository.findAll());
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
        abrigoRepository.save(abrigo);
        return "redirect:/abrigos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Abrigo> abrigo = abrigoRepository.findById(id);
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
        model.addAttribute("abrigos", abrigoRepository.findAll());
        return "abrigos/checkin";
    }
}
