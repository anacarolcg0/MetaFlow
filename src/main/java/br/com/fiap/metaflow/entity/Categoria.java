package br.com.fiap.metaflow.entity;

public enum Categoria {
    CARREIRA("Carreira"),
    HABILIDADES("Habilidades"),
    SAUDE("Saúde"),
    FINANCAS("Finanças"),
    RELACIONAMENTOS("Relacionamentos"),
    PRODUTIVIDADE("Produtividade"),
    BEM_ESTAR("Bem-estar"),
    EDUCACAO("Educação"),
    PROJETOS("Projetos"),
    REFLEXAO_PESSOAL("Reflexão pessoal");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
