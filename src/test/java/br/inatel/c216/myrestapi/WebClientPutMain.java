package br.inatel.c216.myrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.inatel.c216.myrestapi.model.Curso;

public class WebClientPutMain {
    public static void main(String[] args) {

        Curso cursoExistente = new Curso();
        cursoExistente.setId(2L);
        cursoExistente.setDescricao("Python é uma linguagem de programação");
        cursoExistente.setCargaHoraria(80);

        Curso cursoExistenteAtualizado = cursoExistente;
        cursoExistenteAtualizado.setDescricao("REST com Spring Boot e Spring WebFlux");
        cursoExistenteAtualizado.setCargaHoraria(120);

        try {
            ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080/")
                    .put()
                    .uri("cursos/{id}", cursoExistenteAtualizado.getId())
                    .bodyValue(cursoExistenteAtualizado)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            HttpStatus statusCode = responseEntity.getStatusCode();

            System.out.println("Curso Atualizado. Status: " + statusCode);

        } catch (WebClientResponseException e) {
            System.out.println("Status code: " + e.getStatusCode());
        }

    }
}
