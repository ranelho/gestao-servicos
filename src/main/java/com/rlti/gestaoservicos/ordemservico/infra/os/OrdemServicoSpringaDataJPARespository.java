package com.rlti.gestaoservicos.ordemservico.infra.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoSpringaDataJPARespository extends JpaRepository<OrdemServico, Long> {
}
