package com.rlti.gestaoservicos.secretaria.application.service.setor;

import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorRequest;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;

public interface SetorService {
    SetorIdResponse postSetor(Secretaria secretaria, SetorRequest setorRequest);
}
