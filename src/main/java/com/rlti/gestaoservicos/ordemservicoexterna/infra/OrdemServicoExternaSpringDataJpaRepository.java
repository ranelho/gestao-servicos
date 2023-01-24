package com.rlti.gestaoservicos.ordemservicoexterna.infra;

import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdemServicoExternaSpringDataJpaRepository extends JpaRepository<OrdemServicoExterna, UUID> {
}
