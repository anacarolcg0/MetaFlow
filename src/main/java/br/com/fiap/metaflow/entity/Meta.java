package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "metaflow_meta")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeta;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String descricao;
    private Integer valorAlvo;
    private Integer valorAtual = 0;
    private LocalDate prazo;
    private String status = "Em andamento"; // em andamento, concluida, cancelada

    @ManyToOne
    @JoinColumn(name = "id")
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
