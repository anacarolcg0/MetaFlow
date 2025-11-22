package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "metaflow_habilidade")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidade;
    @NotBlank (message = "O nome é obrigatório")
    private String nome;
    @NotBlank (message = "A categoria é obrigatória")
    private String categoria;
    @NotNull (message = "O nível atual é obrigatório")
    private Integer nivelAtual;
    @NotNull (message = "O nível desejado é obrigatório")
    private Integer nivelDesejado;
    @NotNull (message = "O status de aprendizado é obrigatório")
    private Boolean emAprendizado = true;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "O usuário é obrigatório")
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