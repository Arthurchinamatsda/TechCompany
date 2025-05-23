package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.objetos.Pessoa;

@Repository
public interface Repositoriy extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);
}
