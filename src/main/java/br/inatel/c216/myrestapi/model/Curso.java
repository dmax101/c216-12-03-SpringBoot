package br.inatel.c216.myrestapi.model;

public class Curso {

    private Long id;
    private String descricao;
    private Integer cargaHoraria;

    public Curso(Long id, String descricao, Integer cargaHoraria) {
        this.id = id;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", descricao=" + descricao + ", cargaHoraria=" + cargaHoraria + "]";
    }
}
