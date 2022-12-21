package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/setor")
public interface SetorApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SetorIdResponse postSetor(@Valid @RequestBody SetorRequest setorRequest, @RequestParam Secretaria secretaria);
}
