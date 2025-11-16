package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "metaflow_habilidade")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidade;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Integer nivelAtual;
    private Integer nivelDesejado;
    private Boolean emAprendizado = true;
}
