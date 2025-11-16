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
    private String status = "Em andamento"; // EM_ANDAMENTO, CONCLUIDA, CANCELADA
}
