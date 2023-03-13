package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosPendentesResponse;
import com.rlti.gestaoservicos.relatorios.application.api.response.HistoricoEquipamentoResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/relatorios")
@PreAuthorize("hasRole('ADMIN')")
public interface RelatorioApi {

    @GetMapping("/equipamentos/{situacao}")
    @ResponseStatus(code = HttpStatus.OK)
    List<EquipamentosPendentesResponse> getAllOSSituacao(@Valid @PathVariable Situacao situacao);

    @GetMapping("/historicoEquipamento/{patrimonio}")
    @ResponseStatus(code = HttpStatus.OK)
    List<HistoricoEquipamentoResponse>getHistoricoEquipamento(@Valid @PathVariable String patrimonio);

    @GetMapping(value = "/periodo/{dataInicial},{dataFinal}")
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getOSPeriodo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                                                @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal);
}