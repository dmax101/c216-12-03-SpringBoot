package br.inatel.c216.myrestapi;

import br.inatel.c216.myrestapi.model.Curso;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientFluxMain {

  public static void main(String[] args) {
    try {
      Mono<Curso> monoCurso = WebClient
          .create("localhost:8080/cursos/2")
          .get()
          .retrieve()
          .bodyToMono(Curso.class);

      monoCurso.subscribe();
      Curso curso = monoCurso.block();

      System.out.println("Curso encontrado:");
      System.out.println(curso);

    } catch (WebClientResponseException e) {
      System.out.println("Status code: " + e.getStatusCode());
    }
  }
}
