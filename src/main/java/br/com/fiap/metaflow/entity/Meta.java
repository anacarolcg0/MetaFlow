package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "metaflow_meta")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeta;
    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @Positive(message = "O valor alvo deve ser maior que zero")
    @NotNull(message = "O valor alvo é obrigatório")
    private Integer valorAlvo = 0;
    @Min(value = 0, message = "O valor atual deve ser no mínimo 0")
    @NotNull(message = "O valor atual é obrigatório")
    private Integer valorAtual = 0;
    @NotNull(message = "O prazo é obrigatório")
    private LocalDate prazo;
    @NotBlank(message = "O status é obrigatório")
    private String status = "Em andamento"; // em andamento, concluida, cancelada

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "O usuário é obrigatório")
    private Usuario usuario;

    public Long getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Long idMeta) {
        this.idMeta = idMeta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValorAlvo() {
        return valorAlvo;
    }

    public void setValorAlvo(Integer valorAlvo) {
        this.valorAlvo = valorAlvo;
    }

    public Integer getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Integer valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}