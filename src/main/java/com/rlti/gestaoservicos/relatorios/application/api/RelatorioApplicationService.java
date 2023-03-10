package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosPendentesResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class RelatorioApplicationService implements RelatorioService {

    private final OrdemServicoRepository ordemServicoRepository;

    @Override
    public List<EquipamentosPendentesResponse> getAllOSSituacao(Situacao situacao) {
        log.info("[inicia] OrdemServicoApplciationService - getAllOS");
        List<OrdemServico> listOrdemServico = ordemServicoRepository.getAllOSSituacao(situacao);
        log.info("[finaliza] OrdemServicoApplciationService - getAllOS");
        return EquipamentosPendentesResponse.converte(listOrdemServico);
    }
}
