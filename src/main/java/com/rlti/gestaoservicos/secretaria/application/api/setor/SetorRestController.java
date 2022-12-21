package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.application.service.setor.SetorService;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public SetorDetalhadoResponse getSetorPorId(Long idSetor) {
        log.info("[inicia] SetorRestController - postSetor");
        Setor setor = setorService.getSetorPorId(idSetor);
        log.info("[finaliza] SetorRestController - postSetor");
        return new SetorDetalhadoResponse(setor);
    }

    @Override
    public List<SetorListResponse> getTodosSetores() {
        log.info("[inicia] SetorRestController - getTodosSetores");
        List<SetorListResponse> listaSetores = setorService.getTodosSetores();
        log.info("[finaliza] SetorRestController - getTodosSetores");
        return listaSetores;
    }

    @Override
    public void alteraSetor(Long idSetor, SetorAlteracaoRequest setorAlteracaoRequest) {
        log.info("[inicia] SetorRestController - alteraSetor");
        setorService.alteraSetor(idSetor, setorAlteracaoRequest);
        log.info("[finaliza] SetorRestController - alteraSetor");
    }

    @Override
    public void deletaSetorPorId(Long idSetor) {
        log.info("[inicia] SetorRestController - deletaSetorPorId");
        setorService.deletaSetor(idSetor);
        log.info("[finaliza] SetorRestController - deletaSetorPorId");
    }
}
