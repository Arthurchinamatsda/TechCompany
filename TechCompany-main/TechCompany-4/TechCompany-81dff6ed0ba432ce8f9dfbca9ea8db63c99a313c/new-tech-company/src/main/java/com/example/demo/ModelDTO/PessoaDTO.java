package com.example.demo.ModelDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	
	private String nome;
	private String email;
	private String senha;
	
	public PessoaDTO(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	
	
}
