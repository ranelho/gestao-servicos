package com.rlti.gestaoservicos.secretaria.application.repository.secretaria;

import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;

public interface SecretariaRepository {
    Secretaria salva(Secretaria secretaria);
}
