package com.rlti.gestaoservicos.suporte.infra;

import com.rlti.gestaoservicos.handler.APIException;
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
    public Optional<Suporte> buscaSuportePorId(Long idSuporte) {
        log.info("[inicia] SuporteInfraRepository - buscaSuportePorId");
        Optional<Suporte> suporte = suporteSpringDataJPARepository.findById(idSuporte);
        log.info("[finaliza] SuporteInfraRepository - buscaSuportePorId");
        return suporte;
    }

    @Override
    public List<Suporte> getTodosSuportes() {
        log.info("[inicia] SuporteInfraRepository - getTodosSuportes");
        List<Suporte> listaSuporte = suporteSpringDataJPARepository.findAll();
        log.info("[finaliza] SuporteInfraRepository - getTodosSuportes");
        return listaSuporte;
    }

    @Override
    public void deleta(Long idSuporte) {
        log.info("[inicia] SuporteInfraRepository - deleta");
        suporteSpringDataJPARepository.deleteById(idSuporte);
        log.info("[finaliza] SuporteInfraRepository - deleta");
    }
}
