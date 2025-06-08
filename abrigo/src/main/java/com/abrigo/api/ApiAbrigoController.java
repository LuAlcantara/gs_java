package com.abrigo.api;

import com.abrigo.model.Abrigo;
import com.abrigo.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abrigos")
public class ApiAbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @GetMapping
    public List<Abrigo> listar() {
        return abrigoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Abrigo buscarPorId(@PathVariable Long id) {
        return abrigoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Abrigo criar(@RequestBody Abrigo abrigo) {
        return abrigoRepository.save(abrigo);
    }

    @PutMapping("/{id}")
    public Abrigo atualizar(@PathVariable Long id, @RequestBody Abrigo abrigo) {
        abrigo.setId(id);
        return abrigoRepository.save(abrigo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        abrigoRepository.deleteById(id);
    }
}
