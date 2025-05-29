package com.example.demo.seguranca;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.example.demo.model.Pessoa;
@Component("bcrypitSenhaPessoa")
public class BcrypitSenhaPessoa {

    public Pessoa criptografarSenha(Pessoa pessoa) {
        String senhaCriptografada = BCrypt.hashpw(pessoa.getSenha(), BCrypt.gensalt());
        pessoa.setSenha(senhaCriptografada);
        return pessoa;
    }
    
}
