package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.application.service.setor.SetorService;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SetorRestController implements SetorApi{
    private final SetorService setorService;

    @Override
    public SetorIdResponse postSetor(SetorRequest setorRequest, Secretaria secretaria) {
        log.info("[inicia] SetorRestController - postSetor");
        SetorIdResponse setorIdResponse = setorService.postSetor(secretaria, setorRequest);
        log.info("[finaliza] SetorRestController - postSetor");
        return setorIdResponse;
    }
}
