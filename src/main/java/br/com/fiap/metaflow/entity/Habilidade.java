package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "metaflow_habilidade")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidade;
    private String nome;
    private String categoria;
    private Integer nivelAtual;
    private Integer nivelDesejado;
    private Boolean emAprendizado = true;

    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Long getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Long idHabilidade) {
        this.idHabilidade = idHabilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(Integer nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public Integer getNivelDesejado() {
        return nivelDesejado;
    }

    public void setNivelDesejado(Integer nivelDesejado) {
        this.nivelDesejado = nivelDesejado;
    }

    public Boolean getEmAprendizado() {
        return emAprendizado;
    }

    public void setEmAprendizado(Boolean emAprendizado) {
        this.emAprendizado = emAprendizado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
