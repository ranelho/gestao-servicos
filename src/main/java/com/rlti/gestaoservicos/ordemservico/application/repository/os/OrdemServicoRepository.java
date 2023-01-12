package com.rlti.gestaoservicos.ordemservico.application.repository.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;

public interface OrdemServicoRepository {
    OrdemServico salva(OrdemServico ordemServico);
    OrdemServico findOSById(Long idOrdemServico);
    OrdemServico getOSByIdEquipmento(Long idEquipamento);
    List<OrdemServico> getAtendimentos();
    List<OrdemServico> getAllOS();
    void deleta(Long idOrdemServico);
}