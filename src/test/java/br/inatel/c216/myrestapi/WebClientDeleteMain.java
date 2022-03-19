package br.inatel.c216.myrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteMain {
    public static void main(String[] args) {
        try {

            Long cursoId = 2L;

            ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080/")
                    .delete()
                    .uri("cursos/{id}", cursoId)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            HttpStatus statusCode = responseEntity.getStatusCode();

            System.out.println("Curso excluído. Status: " + statusCode);

        } catch (WebClientResponseException e) {
            System.out.println("Status code: " + e.getStatusCode());
        }
    }
}
