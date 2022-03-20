import java.util.HashMap;
import java.util.Map;

import br.inatel.c216.myrestapi.model.Curso;

public class playground {

    private static Map<Long, Curso> mapa = new HashMap<>();

    public static void main(String[] args) {

        Curso c1 = new Curso(1L, "Java é uma linguagem de programação", 100);
        Curso c2 = new Curso(2L, "Python é uma linguagem de programação", 80);
        Curso c3 = new Curso(3L, "C# é uma linguagem de programação", 200);
        Curso c4 = new Curso(4L, "C++ é uma linguagem de programação", 150);
        Curso c5 = new Curso(5L, "C é uma linguagem de programação", 300);

        mapa.put(c1.getId(), c1);
        mapa.put(c2.getId(), c2);
        mapa.put(c3.getId(), c3);
        mapa.put(c4.getId(), c4);
        mapa.put(c5.getId(), c5);

        Curso novoCurso = new Curso();
        novoCurso.setDescricao("Rest com Spring Boot e Spring WebFlux");
        novoCurso.setCargaHoraria(120);
        novoCurso.setId(2L);

        mapa.put(novoCurso.getId(), novoCurso);

        System.out.println("Antes: " + mapa.get(2L));

        System.out.println(mapa.toString());
    }
}
