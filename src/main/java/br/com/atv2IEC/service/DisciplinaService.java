package br.com.atv2IEC.service;

import br.com.atv2IEC.model.Disciplina;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplinaService {
    private final Map<Integer, Disciplina> disciplinas = new HashMap<>();
    private int nextId = 1;

    public DisciplinaService() {
        this.criarDisciplina(new Disciplina(null, "Laboratório de Desenvolvimento Web", "Prof. Diego Max"));
        this.criarDisciplina(new Disciplina(null, "Integração e Entrega Contínua", "Prof. Icaro Davies"));
    }

    public List<Disciplina> listarTodas() {
        return new ArrayList<>(disciplinas.values());
    }

    public Optional<Disciplina> buscarPorId(Integer id) {
        return Optional.ofNullable(disciplinas.get(id));
    }

    public Disciplina criarDisciplina(Disciplina disciplina) {
        disciplina.setId(nextId++);
        disciplinas.put(disciplina.getId(), disciplina);
        return disciplina;
    }
}
