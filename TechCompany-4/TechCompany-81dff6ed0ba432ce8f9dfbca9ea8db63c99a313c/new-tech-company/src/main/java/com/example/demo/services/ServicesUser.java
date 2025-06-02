package com.example.demo.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.ModelDTO.PessoaDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.repossitory.Repositoriy;
import com.example.demo.security.TokenUtil;

import ch.qos.logback.core.subst.Token;
import jakarta.validation.Valid;

@Service
public class ServicesUser {
    
    private Repositoriy pessoaRepository;
    private PasswordEncoder passwordEncoder;
    
    public ServicesUser(Repositoriy pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Pessoa criarUsuario(Pessoa pessoa) {
        String encoder = this.passwordEncoder.encode(pessoa.getSenha());
        pessoa.setSenha(encoder);
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
    	List<Pessoa> lista = pessoaRepository.findAll();
        return lista;
    }
     public Pessoa editarUsuario(Pessoa pessoa) {
         String encoder = this.passwordEncoder.encode(pessoa.getSenha());
         pessoa.setSenha(encoder);
    	 Pessoa pessoaEditada = pessoaRepository.save(pessoa);
    	 return pessoaEditada;
     }
     public Boolean excluirUsuario(Long id) {
    	 pessoaRepository.deleteById(id);
    	 return true;
     }

    public Boolean validarSenha(Pessoa pessoa) {
		String senha = pessoaRepository.getById(pessoa.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(pessoa.getSenha(), senha);
        return valid;
        }

	public Token gerarToken(@Valid PessoaDTO pessoa) {
		Pessoa user = pessoaRepository.findByNomeOrEmail(pessoa.getNome(), pessoa.getEmail());
		if(user != null) {
			Boolean valid = passwordEncoder.matches(pessoa.getSenha(), user.getSenha());
			if(valid) {
				return new Token(null, TokenUtil.createToken(user));
			}
		}
		return null;
	}
    
}