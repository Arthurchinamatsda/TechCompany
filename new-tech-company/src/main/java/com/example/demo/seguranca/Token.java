package com.example.demo.seguranca;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Token {

    private final String segredo = "minhaChaveSecretaMuitoSegura123!";

    public String gerarToken(String email) {
        long validade = 3600000; // 1 hora
        Date agora = new Date();
        Date expiracao = new Date(agora.getTime() + validade);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(agora)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, segredo)
                .compact();
    }

    public String validarToken(String token) {
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(segredo)
                .parseClaimsJws(token)
                .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
