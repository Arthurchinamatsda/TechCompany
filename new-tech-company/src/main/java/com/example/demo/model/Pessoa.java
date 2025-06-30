package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatorio")
    @Column(name = "nome" , length = 200 , nullable = false)
    private String nome;

    @Email(message = "insira um email valido")
    @NotBlank(message = "O email é obrigatorio")
    @Column(name = "email" , length = 200 , nullable = false)
    private String email;
    
    @NotBlank(message = "sehna é obrigatoria")
    @Column(name = "senha" , columnDefinition = "TEXT" , nullable = false)
    private String senha;
}
