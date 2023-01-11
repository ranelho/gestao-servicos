package com.rlti.gestaoservicos.ordemservico.application.repository.servico;

import com.rlti.gestaoservicos.ordemservico.domain.Servico;

import java.util.List;

public interface ServicoRepository {
    Servico salva(Servico servico);
    Servico findServicoById(Long idServico);
    List<Servico> getAllServicos();
    void deleta(Long idServico);
}
