package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosPendentesResponse;
import com.rlti.gestaoservicos.relatorios.application.api.response.HistoricoEquipamentoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
}
