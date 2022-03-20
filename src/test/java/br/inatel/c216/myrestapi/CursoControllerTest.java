package br.inatel.c216.myrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.c216.myrestapi.model.Curso;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CursoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void deveListarCursos() {
        webTestClient
                .get()
                .uri("/cursos")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    void dadoCursoIdValido_quandoGetCursoId_entaoRespondeComCursoValido() {
        Long idValido = 1L;

        Curso cursoRespondido = webTestClient
                .get()
                .uri("/cursos/{id}", idValido)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Curso.class)
                .returnResult()
                .getResponseBody();

        assertEquals(cursoRespondido.getId(), idValido);
    }

    @Test
    void dadoCursoIdInvalido_quandoGetCursoId_entaoRespondeComStatus404() {
        Long idInvalido = -1L;

        webTestClient
                .get()
                .uri("/cursos/{id}", idInvalido)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void dadoCursoExistente_quandoPutCurso_entaoRespondeComCursoAtualizado() {
        Curso cursoExistente = new Curso(1L, "Descrição do Curso de Teste", 80);

        Curso cursoAtualizado = webTestClient
                .put()
                .uri("/cursos/{id}", cursoExistente.getId())
                .bodyValue(cursoExistente)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Curso.class)
                .returnResult().getResponseBody();

        assertEquals(cursoExistente.getId(), cursoAtualizado.getId());
        assertEquals(cursoExistente.getDescricao(), cursoAtualizado.getDescricao());
        assertEquals(cursoExistente.getCargaHoraria(), cursoAtualizado.getCargaHoraria());

    }

}
