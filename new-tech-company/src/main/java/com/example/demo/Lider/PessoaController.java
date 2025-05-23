package com.example.demo.Lider;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.objetos.Pessoa;
import com.example.demo.repositorios.Repositoriy;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class PessoaController {

    private final Repositoriy repository1;

    public PessoaController(Repositoriy repository1) {
        this.repository1 = repository1;
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return repository1.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return repository1.findAll();
    }
}



