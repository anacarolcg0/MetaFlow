package br.com.fiap.metaflow.repository;

import br.com.fiap.metaflow.entity.CheckInDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInDiarioRepository extends JpaRepository<CheckInDiario, Long> {
}