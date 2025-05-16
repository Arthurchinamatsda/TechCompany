package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PessoaController {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "IndexHome"; // Vai procurar form.html na pasta templates
    }

    @PostMapping("/salvar")
    public String salvarNome(@RequestParam String nome1 , @RequestParam String email1 , @RequestParam String senha1 , @RequestParam String senha2) {
        System.out.print("Nome recebido: " + nome1);
        System.out.print("Email Recebido: " + email1);
        System.out.print("Senha recebida: " + senha1);
        System.out.print("Senha recebido: " + senha2);
        return "IndexHomeHome";
    }
}

