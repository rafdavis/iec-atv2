package br.com.atv2IEC.controller;

import br.com.atv2IEC.model.Disciplina;
import br.com.atv2IEC.service.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Disciplina> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> criar(@RequestBody Disciplina disciplina) {
        Disciplina criada = service.criarDisciplina(disciplina);
        return new ResponseEntity<>(criada, HttpStatus.CREATED);
    }
}
