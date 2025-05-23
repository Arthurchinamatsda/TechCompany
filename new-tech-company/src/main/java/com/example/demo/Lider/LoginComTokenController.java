package com.example.demo.Lider;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.objetos.Pessoa;
import com.example.demo.repositorios.Repositoriy;
import com.example.demo.seguranca.Token;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "*")
public class LoginComTokenController {

    @Autowired
    private Repositoriy repositorio;

    @Autowired
    private Token tokenJwtUtil;

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Pessoa usuarioLogin) {
    Pessoa usuario = repositorio.findByEmail(usuarioLogin.getEmail());

    if (usuario != null && usuario.getSenha().equals(usuarioLogin.getSenha())) {
        String token = tokenJwtUtil.gerarToken(usuario.getEmail());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("Email ou senha inválidos");
    }
}

}





