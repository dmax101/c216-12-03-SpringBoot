package br.inatel.c216.myrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.c216.myrestapi.model.Curso;
import br.inatel.c216.myrestapi.service.CursoServico;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoServico servico;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> listar() {

        return servico.pesquisarCurso();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso cursoPorId(@PathVariable("id") Long cursoId) {

        Curso curso = servico.buscarCursoPorId(cursoId);

        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }

        return servico.buscarCursoPorId(cursoId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso salvar(@RequestBody Curso curso) {

        return servico.salvarCurso(curso);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Curso atualizar(@PathVariable("id") Long cursoId, @RequestBody Curso curso) {

        curso.setId(cursoId);

        return servico.atualizarCurso(curso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso deletar(@PathVariable("id") Long cursoId) {

        Curso curso = servico.deletarCurso(cursoId);

        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }

        return curso;
    }

}
