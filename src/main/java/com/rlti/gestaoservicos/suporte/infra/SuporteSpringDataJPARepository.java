package com.rlti.gestaoservicos.suporte.infra;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuporteSpringDataJPARepository extends JpaRepository<Suporte, Long> {
}
