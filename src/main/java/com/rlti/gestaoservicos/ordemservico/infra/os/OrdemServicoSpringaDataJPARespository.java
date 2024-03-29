package com.rlti.gestaoservicos.ordemservico.infra.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrdemServicoSpringaDataJPARespository extends JpaRepository<OrdemServico, UUID> {
  // @Query("SELECT o FROM OrdemServico o WHERE o.situacao <> com.rlti.gestaoservicos.ordemservico.domain.Situacao.FINALIZADO")
   List<OrdemServico> findAllDistinctBySituacao(Situacao finalizado);

   @Query(value = "SELECT * FROM ordem_servico WHERE equipamento_id = :idEquipamento ORDER BY id_ordem_servico DESC LIMIT 1", nativeQuery = true)
   OrdemServico findLastOrdemServicoByIdEquipamento(Long idEquipamento);

  // @Query("SELECT o FROM OrdemServico o WHERE o.situacao = :situacao AND o.idEquipamento IS NOT NULL")
   List<OrdemServico> findBySituacaoAndEquipamentoIsNotNull(Situacao situacao);

   //@Query("SELECT o FROM OrdemServico o WHERE o.Equipamento.idEquipamento = :idEquipamento")
   List<OrdemServico> findAllByEquipamentoIdEquipamento(Long idEquipamento);

   List<OrdemServico> findByDataInicialBetween(LocalDate dataInicial, LocalDate dataFinal);
}
