package com.rlti.gestaoservicos.secretaria.application.service.secretaria;

import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaListResponse;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;

import java.util.List;

public interface SecretariaService {
    SecretariaIdResponse criaSecretaria(SecretariaRequest secretariaRequest);
    Secretaria findSecretariaById(Long idSecretaria);
    List<SecretariaListResponse> getAllSecretarias();
     void alteraSecretaria(Long idSecretaria, SecretariaAlteracaoRequest secretariaAlteracaoRequest);
    void deletaSecretariaById(Long idSecretaria);
}
