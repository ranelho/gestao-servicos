package com.rlti.gestaoservicos.secretaria.application.service.secretaria;

import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;

public interface SecretariaService {
    SecretariaIdResponse criaSecretaria(SecretariaRequest secretariaRequest);
}
