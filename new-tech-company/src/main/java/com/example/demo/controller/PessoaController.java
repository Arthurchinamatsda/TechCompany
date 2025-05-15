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
    public String salvarNome(@RequestParam String nome1) {
        System.out.println("Nome recebido: " + nome1);
        // Aqui depois vamos salvar no banco
        return "redirect:/";
    }
    
    @PostMapping("/salvar")
    public String salvarSenha(@RequestParam String email1){
        System.out.println("email recebido" + email1);
    }
}

