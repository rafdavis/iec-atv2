package br.com.atv2IEC.controller;

import br.com.atv2IEC.model.Disciplina;
import br.com.atv2IEC.service.DisciplinaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaControllerTest {

    private DisciplinaController controller;

    @BeforeEach
    void setup() {
        controller = new DisciplinaController(new DisciplinaService());
    }

    @Test
    void testListarTodas() {
        List<Disciplina> disciplinas = controller.listarTodas();
        assertEquals(2, disciplinas.size());
    }

    @Test
    void testBuscarPorIdValido() {
        ResponseEntity<Disciplina> response = controller.buscarPorId(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Programação Web", response.getBody().getNome());
    }

    @Test
    void testBuscarPorIdInvalido() {
        ResponseEntity<Disciplina> response = controller.buscarPorId(999);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCriarDisciplina() {
        Disciplina nova = new Disciplina(null, "Engenharia de Software", "Prof. Lima");
        ResponseEntity<Disciplina> response = controller.criar(nova);
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody().getId());
    }
}
