package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosPendentesResponse;
import com.rlti.gestaoservicos.relatorios.application.api.response.HistoricoEquipamentoResponse;
import com.rlti.gestaoservicos.suporte.application.repository.SuporteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class RelatorioApplicationService implements RelatorioService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final SuporteRepository suporteRepository;

    @Override
    public List<EquipamentosPendentesResponse> getAllOSSituacao(Situacao situacao) {
        log.info("[inicia] OrdemServicoApplciationService - getAllOS");
        List<OrdemServico> listOrdemServico = ordemServicoRepository.getAllOSSituacao(situacao);
        log.info("[finaliza] OrdemServicoApplciationService - getAllOS");
        return EquipamentosPendentesResponse.converte(listOrdemServico);
    }

    @Override
    public List<HistoricoEquipamentoResponse> getHistoricoEquipamento(String patrimonio) {
        log.info("[inicia] OrdemServicoApplciationService - getHistoricoEquipamento");
        Long idEquipamento = equipamentoRepository.findEquipamentoByPatrimonio(patrimonio)
                .orElseThrow(() ->  {
                            throw APIException.build(HttpStatus.NOT_FOUND, "Equipamento não encontrado");
                        }
                ).getIdEquipamento();
        List<OrdemServico> ordemServicoList = ordemServicoRepository.getHistoricoEquipamento(idEquipamento);
        log.info("[finaliza] OrdemServicoApplciationService - getHistoricoEquipamento");
        return HistoricoEquipamentoResponse.converte(ordemServicoList);
    }

    @Override
    public List<OrdemServicoListResponse> getOSPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] OrdemServicoApplciationService - getOSPeriodo");
        List<OrdemServico> ordemServicoList = ordemServicoRepository.getOSPeriodo(dataInicial, dataFinal);
        log.info("[finaliza] OrdemServicoApplciationService - getOSPeriodo");
        return OrdemServicoListResponse.converte(ordemServicoList);
    }
}
