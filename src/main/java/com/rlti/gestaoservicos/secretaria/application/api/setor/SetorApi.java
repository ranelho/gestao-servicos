package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/setor")
public interface SetorApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SetorIdResponse postSetor(@Valid @RequestBody SetorRequest setorRequest, @RequestParam Secretaria secretaria);

    @GetMapping(value = "/{idSetor}")
    @ResponseStatus(code = HttpStatus.OK)
    SetorDetalhadoResponse getSetorById(@PathVariable Long idSetor);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<SetorListResponse> getAllSetores();

    @PatchMapping (value = "/update/{idSetor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraSetor(@PathVariable Long idSetor, @Valid @RequestBody SetorAlteracaoRequest setorAlteracaoRequest);

    @DeleteMapping(value = "/{idSetor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaSetorById(@PathVariable Long idSetor);
}
