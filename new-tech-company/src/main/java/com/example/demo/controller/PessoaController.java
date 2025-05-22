package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.repossitory.Repositoriy;
import com.example.demo.model.Pessoa;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class PessoaController {
    
    @Autowired
    private final Repositoriy repository1;

    public PessoaController(Repositoriy repository1) {
        this.repository1 = repository1;
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return repository1.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return repository1.findAll();
    }
}



