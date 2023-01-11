package com.rlti.gestaoservicos.secretaria.application.repository.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;

import java.util.List;

public interface SecretariaRepository {
    Secretaria salva(Secretaria secretaria);
    Secretaria findSecretariaById(Long idSecretaria);
    List<Secretaria> getAllSecretarias();
    void deleta(Long idSecretaria);
}
