package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosPendentesResponse;
import com.rlti.gestaoservicos.relatorios.application.api.response.HistoricoEquipamentoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
public class RelatorioRestController implements RelatorioApi {
    private final RelatorioService relatorioService;

    public List<EquipamentosPendentesResponse> getAllOSSituacao(Situacao situacao) {
        log.info("[inicia] RelatoriosRestController - getAllOSSituacao");
        List<EquipamentosPendentesResponse> listaEquipamentos = relatorioService.getAllOSSituacao(situacao);
        log.info("[finaliza] RelatoriosRestController - getAllOSSituacao");
        return listaEquipamentos;
    }

    @Override
    public List<HistoricoEquipamentoResponse> getHistoricoEquipamento(String patrimonio) {
        log.info("[inicia] RelatoriosRestController - getHistoricoEquipamento");
        List<HistoricoEquipamentoResponse> historico = relatorioService.getHistoricoEquipamento(patrimonio);
        log.info("[finaliza] RelatoriosRestController - getHistoricoEquipamento");
        return  historico;
    }

}