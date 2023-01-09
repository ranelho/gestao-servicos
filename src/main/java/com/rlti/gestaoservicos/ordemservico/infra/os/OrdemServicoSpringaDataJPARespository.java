package com.rlti.gestaoservicos.ordemservico.infra.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdemServicoSpringaDataJPARespository extends JpaRepository<OrdemServico, Long> {
   @Query("SELECT o FROM OrdemServico o WHERE " +
           "o.situacao <> com.rlti.gestaoservicos.ordemservico.domain.Situacao.CONCLUÍDO " +
           "AND  o.situacao <> com.rlti.gestaoservicos.ordemservico.domain.Situacao.SEM_SOLUÇÃO " +
           "AND o.situacao <> com.rlti.gestaoservicos.ordemservico.domain.Situacao.REPARADO_ENTREGUE ")
    List<OrdemServico> findAllAtendimentos();
}
