package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.secretaria.domain.Setor;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Value
public class OrdemServicoResquest {
    @NotNull
    String patrimonio;
    Long idSetor;
    @NotNull
    List<Suporte> suportes;
    @Size(message = "Campo descrição não pode estar vazio", min = 3, max = 255)
    String descricaoProblema;
    String observacao;

    @AssertTrue(message = "Informe o patrimônio ou o setor.")
    private boolean isPatrimonioOrIdSetorPresent() {
        return !StringUtils.isEmpty(patrimonio) || idSetor != null;
    }
}

