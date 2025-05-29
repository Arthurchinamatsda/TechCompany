package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.repossitory.Repositoriy;
import com.example.demo.seguranca.BcrypitSenhaPessoa;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class PessoaController {
    
    private final Repositoriy pessoaRepository;
    private final BcrypitSenhaPessoa bcryptSenhaPessoa;

    @Autowired
    public PessoaController(Repositoriy pessoaRepository, BcrypitSenhaPessoa bcryptSenhaPessoa) {
        this.pessoaRepository = pessoaRepository;
        this.bcryptSenhaPessoa = bcryptSenhaPessoa;
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        Pessoa pessoaComSenhaCriptografada = bcryptSenhaPessoa.criptografarSenha(pessoa);
        return pessoaRepository.save(pessoaComSenhaCriptografada);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }
}