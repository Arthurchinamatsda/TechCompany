package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityPessoa{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(csrf -> csrf.disable())
				   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				   .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST , "/api/usuarios/login").permitAll()
				   .requestMatchers(HttpMethod.GET,"/").permitAll()
				   .requestMatchers("/css/**",
				   								"/js/**").permitAll()
				   .requestMatchers(HttpMethod.GET, "/home").permitAll()
				   .requestMatchers(HttpMethod.GET, "/api/usuarios").permitAll()
				   .anyRequest().authenticated()
				   ).addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class)
				   .build();
	}

}
