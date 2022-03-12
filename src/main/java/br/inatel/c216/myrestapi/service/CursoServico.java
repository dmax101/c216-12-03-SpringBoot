package br.inatel.c216.myrestapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.inatel.c216.myrestapi.model.Curso;

@Service
public class CursoServico {

    private Map<Long, Curso> mapa = new HashMap<>();

    public List<Curso> pesquisarCurso() {

        return mapa.entrySet().stream().map(Map.Entry::getValue).collect(java.util.stream.Collectors.toList());
    }

    public Curso buscarCursoPorId(Long id) {
        return mapa.get(id);
    }

    public Curso salvarCurso(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(System.currentTimeMillis());
        }
        mapa.put(curso.getId(), curso);
        return curso;
    }

    public Curso atualizarCurso(Curso curso) {
        mapa.put(curso.getId(), curso);
        return curso;
    }

    public Curso deletarCurso(Long id) {
        return mapa.remove(id);
    }

    @PostConstruct
    private void inicializarMapa() {
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
    }
}
