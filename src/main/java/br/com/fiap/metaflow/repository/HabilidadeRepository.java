package br.com.fiap.metaflow.repository;

import br.com.fiap.metaflow.entity.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository  extends JpaRepository<Habilidade, Long> {
}