package br.com.fiap.metaflow.repository;

import br.com.fiap.metaflow.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository <Meta, Long> {
}
