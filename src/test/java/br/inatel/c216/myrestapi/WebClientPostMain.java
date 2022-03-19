package br.inatel.c216.myrestapi;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.c216.myrestapi.model.Curso;

public class WebClientPostMain {
    public static void main(String[] args) {
        Curso novoCurso = new Curso();
        novoCurso.setDescricao("Dominando Spring WebFlux 3");
        novoCurso.setCargaHoraria(80);

        Curso cursoCriado = WebClient.create("http://localhost:8080/cursos/")
                .post()
                .bodyValue(novoCurso)
                .retrieve()
                .bodyToMono(Curso.class)
                .block();

        System.out.println("Curso criado:");
        System.out.println(cursoCriado); // com ID preenchido
    }
}
