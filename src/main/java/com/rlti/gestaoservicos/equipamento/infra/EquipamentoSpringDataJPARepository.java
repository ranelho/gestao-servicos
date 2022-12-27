package com.rlti.gestaoservicos.equipamento.infra;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoSpringDataJPARepository extends JpaRepository<Equipamento, Long> {
}
