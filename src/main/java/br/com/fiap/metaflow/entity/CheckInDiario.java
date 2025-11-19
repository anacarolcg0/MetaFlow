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

}
