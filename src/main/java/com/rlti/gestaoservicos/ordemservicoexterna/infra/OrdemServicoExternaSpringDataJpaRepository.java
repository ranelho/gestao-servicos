package com.rlti.gestaoservicos.ordemservicoexterna.infra;

import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrdemServicoExternaSpringDataJpaRepository extends JpaRepository<OrdemServicoExterna, UUID> {
    @Query("SELECT o FROM OrdemServicoExterna o WHERE o.situacao <> com.rlti.gestaoservicos.ordemservico.domain.Situacao.FINALIZADO")
    List<OrdemServicoExterna> findAllAtendimentos();
}
