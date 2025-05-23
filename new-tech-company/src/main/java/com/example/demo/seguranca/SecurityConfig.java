package com.example.demo.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFiltro filtroToken;

    public SecurityConfig(JwtFiltro filtroToken) {
        this.filtroToken = filtroToken;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/token/login", "/", "/style.css", "/script.js").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(filtroToken, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}