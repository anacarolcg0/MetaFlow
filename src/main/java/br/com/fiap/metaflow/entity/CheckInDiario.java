package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "metaflow_checkin")
public class CheckInDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheckInDiario;
    private LocalDate data;

    @Min(1) @Max(10)
    private Integer humor;
    @Min(1) @Max(10)
    private Integer qualidadeSono;
    @Min(1) @Max(10)
    private Integer nivelEstresse;
    @Min(1) @Max(10)
    private Integer produtividade;

    private Integer tempoTrabalho;
    private Integer tempoAprendizado;
    private Integer tempoLazer;

    private String anotacoes;

    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Long getIdCheckInDiario() {
        return idCheckInDiario;
    }

    public void setIdCheckInDiario(Long idCheckInDiario) {
        this.idCheckInDiario = idCheckInDiario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getHumor() {
        return humor;
    }

    public void setHumor(Integer humor) {
        this.humor = humor;
    }

    public Integer getQualidadeSono() {
        return qualidadeSono;
    }

    public void setQualidadeSono(Integer qualidadeSono) {
        this.qualidadeSono = qualidadeSono;
    }

    public Integer getNivelEstresse() {
        return nivelEstresse;
    }

    public void setNivelEstresse(Integer nivelEstresse) {
        this.nivelEstresse = nivelEstresse;
    }

    public Integer getProdutividade() {
        return produtividade;
    }

    public void setProdutividade(Integer produtividade) {
        this.produtividade = produtividade;
    }

    public Integer getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(Integer tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }

    public Integer getTempoAprendizado() {
        return tempoAprendizado;
    }

    public void setTempoAprendizado(Integer tempoAprendizado) {
        this.tempoAprendizado = tempoAprendizado;
    }

    public Integer getTempoLazer() {
        return tempoLazer;
    }

    public void setTempoLazer(Integer tempoLazer) {
        this.tempoLazer = tempoLazer;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
