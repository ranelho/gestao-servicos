package com.rlti.gestaoservicos.ordemservico.application.repository.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.suporte.domain.Suporte;

import java.util.List;

public interface OrdemServicoRepository {
    OrdemServico salva(OrdemServico ordemServico);
    OrdemServico buscaOSPorId(Long idOrdemServico);
    List<OrdemServico> getTodosOS();
    void deleta(Long idOrdemServico);
    List<OrdemServico> getAtendimentos();
}
