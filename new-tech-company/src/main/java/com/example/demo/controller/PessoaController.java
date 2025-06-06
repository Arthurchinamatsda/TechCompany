package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModelDTO.PessoaDTO;
import com.example.demo.model.Pessoa;
import com.example.demo.services.ServicesUser;

import jakarta.validation.Valid;
import com.example.demo.security.Token; 


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class PessoaController {
    
    private final ServicesUser servicesUser;

    public PessoaController(ServicesUser servicesUser) {
        this.servicesUser = servicesUser;
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarUsuario(@Valid @RequestBody Pessoa pessoa) {
        return ResponseEntity.status(201).body(servicesUser.criarUsuario(pessoa));
        
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarUsuarios() {
    	return ResponseEntity.status(200).body(servicesUser.listar());
    }
    
    @PutMapping
    public ResponseEntity<Pessoa> editarUsuario(@Valid @RequestBody Pessoa pessoa){
    	return ResponseEntity.status(200).body(servicesUser.editarUsuario(pessoa));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
    	servicesUser.excluirUsuario(id);
    	return ResponseEntity.status(204).body(null);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Token> logar(@Valid @RequestBody PessoaDTO pessoa) {
    	Token token = servicesUser.gerarToken(pessoa);
        if(token != null) {
        	return ResponseEntity.ok(token);
        }
    	return ResponseEntity.status(403).body(null);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
    	Map<String, String> errors = new HashMap<>();
    	ex.getBindingResult().getAllErrors().forEach((error) ->{
    		String fielName = ((FieldError) error).getField();
    		String errorMessage = error.getDefaultMessage();
    		errors.put(fielName, errorMessage);
    	});
    	return errors;
    }
}