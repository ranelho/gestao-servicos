package com.rlti.gestaoservicos.suporte.infra;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.suporte.application.repository.SuporteRepository;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Log4j2
@RequiredArgsConstructor
public class SuporteInfraRepository implements SuporteRepository {

    private final SuporteSpringDataJPARepository suporteSpringDataJPARepository;
    @Override
    public Suporte salva(Suporte suporte) {
        log.info("[inicia] SuporteInfraRepository - salva");
        try {
            suporteSpringDataJPARepository.save(suporte);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Suporte já cadastrada!", e);
        }
        log.info("[finaliza] SuporteInfraRepository - salva");
        return suporte;
    }

    @Override
    public Suporte findSuporteById(Long idSuporte) {
        log.info("[inicia] SuporteInfraRepository - findSuporteById");
        Optional<Suporte> optionalSuporte = suporteSpringDataJPARepository.findById(idSuporte);
        Suporte suporte = optionalSuporte.orElseThrow(
                () -> { throw APIException.build(HttpStatus.NOT_FOUND, "Suporte inexistente!");                }
        );
        log.info("[finaliza] SuporteInfraRepository - findSuporteById");
        return suporte;
    }

    @Override
    public List<Suporte> getAllSuportes() {
        log.info("[inicia] SuporteInfraRepository - getAllSuportes");
        List<Suporte> listaSuporte = suporteSpringDataJPARepository.findAll();
        log.info("[finaliza] SuporteInfraRepository - getAllSuportes");
        return listaSuporte;
    }

    @Override
    public void deleta(Long idSuporte) {
        log.info("[inicia] SuporteInfraRepository - deleta");
        suporteSpringDataJPARepository.deleteById(idSuporte);
        log.info("[finaliza] SuporteInfraRepository - deleta");
    }
}
