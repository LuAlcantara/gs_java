package com.abrigo.controller;

import com.abrigo.model.CheckIn;
import com.abrigo.model.Abrigo;
import com.abrigo.repository.AbrigoRepository;
import com.abrigo.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkins")
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @GetMapping
    public String listarCheckins(Model model) {
        model.addAttribute("checkins", checkInRepository.findAll());
        return "abrigos/checkins";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("checkIn", new CheckIn());
        model.addAttribute("abrigos", abrigoRepository.findAll());
        return "abrigos/checkin";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        CheckIn checkIn = checkInRepository.findById(id).orElseThrow();
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("abrigos", abrigoRepository.findAll());
        return "abrigos/checkin";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("checkIn") CheckIn checkIn) {
        if (checkIn.getId() != null) {
            CheckIn existente = checkInRepository.findById(checkIn.getId()).orElse(null);
            if (existente != null) {
                existente.setNome(checkIn.getNome());
                existente.setDocumento(checkIn.getDocumento());
                existente.setAbrigo(abrigoRepository.findById(checkIn.getAbrigo().getId()).orElse(null));
                checkInRepository.save(existente);
                return "redirect:/checkins";
            }
        }

        checkIn.setAbrigo(abrigoRepository.findById(checkIn.getAbrigo().getId()).orElse(null));
        checkInRepository.save(checkIn);
        return "redirect:/checkins";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        checkInRepository.deleteById(id);
        return "redirect:/checkins";
    }
}
