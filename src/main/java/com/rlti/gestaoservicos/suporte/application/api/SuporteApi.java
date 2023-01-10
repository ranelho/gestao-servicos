package com.rlti.gestaoservicos.suporte.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/suporte")
public interface SuporteApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SuporteIdResponse postSuporte(@Valid @RequestBody SuporteRequest suporteRequest);

    @GetMapping(value = "/{idSuporte}")
    @ResponseStatus(code = HttpStatus.OK)
    SuporteDetalhadoResponse getSuportePorId(@PathVariable Long idSuporte);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<SuporteListResponse> getTodosSuportes();

    @PatchMapping (value = "/update/{idSuporte}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraSuporte(@PathVariable Long idSuporte, @Valid @RequestBody SuporteAlteracaoRequest suporteAlteracaoRequest);

    @DeleteMapping(value = "/{idSuporte}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaSuportePorId(@PathVariable Long idSuporte);

    @GetMapping(value = "/ordem-servico/{idSuporte}")
    @ResponseStatus(code = HttpStatus.OK)
    SuporteOSListResponse getOSSuportePorId(@PathVariable Long idSuporte);
}
