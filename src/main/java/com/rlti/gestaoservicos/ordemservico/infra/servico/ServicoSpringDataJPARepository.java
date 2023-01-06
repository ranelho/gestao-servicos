package com.rlti.gestaoservicos.ordemservico.infra.servico;

import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoSpringDataJPARepository extends JpaRepository<Servico, Long> {
}
