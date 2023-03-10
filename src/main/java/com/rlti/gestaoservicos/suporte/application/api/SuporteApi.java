package com.rlti.gestaoservicos.suporte.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/suporte")
@PreAuthorize("hasRole('ADMIN')")
public interface SuporteApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SuporteIdResponse postSuporte(@Valid @RequestBody SuporteRequest suporteRequest);

    @GetMapping(value = "/{idSuporte}")
    @ResponseStatus(code = HttpStatus.OK)
    SuporteDetalhadoResponse getSuporteById(@PathVariable Long idSuporte);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<SuporteListResponse> getAllSuportes();

    @PatchMapping (value = "/update/{idSuporte}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraSuporte(@PathVariable Long idSuporte, @Valid @RequestBody SuporteAlteracaoRequest suporteAlteracaoRequest);

    @DeleteMapping(value = "/{idSuporte}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaSuporteById(@PathVariable Long idSuporte);

    @GetMapping(value = "/ordem-servico/{idSuporte}")
    @ResponseStatus(code = HttpStatus.OK)
    SuporteOSListResponse getOSSuporteById(@PathVariable Long idSuporte);
}
