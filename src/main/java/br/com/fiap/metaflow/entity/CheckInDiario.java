package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "metaflow_checkin")
public class CheckInDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheckInDiario;
    @NotNull (message = "A data do check-in é obrigatória")
    private LocalDate data;
    @Min(1) @Max(10)
    @NotNull (message = "O humor é obrigatório")
    private Integer humor;
    @Min(1) @Max(10)
    @NotNull (message = "A qualidade do sono é obrigatória")
    private Integer qualidadeSono;
    @Min(1) @Max(10)
    @NotNull (message = "O nível de estresse é obrigatório")
    private Integer nivelEstresse;
    @Min(1) @Max(10)
    @NotNull (message = "A produtividade é obrigatória")
    private Integer produtividade;
    @NotNull (message = "O tempo de trabalho é obrigatório")
    private Integer tempoTrabalho;
    @NotNull (message = "O tempo de aprendizado é obrigatório")
    private Integer tempoAprendizado;
    @NotNull (message = "O tempo de lazer é obrigatório")
    private Integer tempoLazer;
    @Size(max = 500, message = "As anotações podem ter no máximo 500 caracteres")
    private String anotacoes;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "O usuário é obrigatório")
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