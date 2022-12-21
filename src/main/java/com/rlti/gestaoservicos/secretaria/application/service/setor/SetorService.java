package com.rlti.gestaoservicos.secretaria.application.service.setor;

import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorDetalhadoResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorRequest;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;

public interface SetorService {
    SetorIdResponse postSetor(Secretaria secretaria, SetorRequest setorRequest);
    Setor getSetorPorId(Long idSetor);
}
