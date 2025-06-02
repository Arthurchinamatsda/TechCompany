package com.example.demo.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pessoa;

@Repository
public interface Repositoriy extends JpaRepository<Pessoa, Long>{

	public void deleteById(Long id);
	public Pessoa getById(Long id);
	public Pessoa findByNomeOrEmail(String nome, String email);
}
