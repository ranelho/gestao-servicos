package com.rlti.gestaoservicos.equipamento.infra;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EquipamentoSpringDataJPARepository extends JpaRepository<Equipamento, Long> {
    Optional<Equipamento> findByPatrimonio(String patrimonio);
}
