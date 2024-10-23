package com.rlti.gestaoservicos.secretaria.infra.setor;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
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
public class SetorInfraRepository implements SetorRepository {
    private final SetorSpringDataJPARepository setorSpringDataJPARepository;

    @Override
    public Setor salva(Setor setor) {
        log.info("[inicia] SetorInfraRepository - salva");
        try{
            Setor setorSalvo = setorSpringDataJPARepository.save(setor);
            log.info("[finaliza] SetorInfraRepository - salva");
            return setorSalvo;
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Setor já cadastrado!", e);
        }
    }

    @Override
    public Setor findSetorById(Long idSetor) {
        log.info("[inicia] SetorInfraRepository - findSetorById");
        Optional<Setor> optionalSetor = setorSpringDataJPARepository.findById(idSetor);
        Setor setor = optionalSetor.orElseThrow(
                () -> APIException.build(HttpStatus.NOT_FOUND, "Setor inexistente!")
        );
        log.info("[finaliza] SetorInfraRepository - findSetorById");
        return setor;
    }

    @Override
    public List<Setor> findSetores() {
        log.info("[inicia] SetorInfraRepository - findSetores");
        List<Setor> setor = setorSpringDataJPARepository.findAll();
        log.info("[finaliza] SetorInfraRepository - findSetores");
        return setor;
    }

    @Override
    public void deleta(Long idSetor) {
        log.info("[inicia] SetorInfraRepository - deleta");
        setorSpringDataJPARepository.deleteById(idSetor);
        log.info("[finaliza] SetorInfraRepository - deleta");
    }
}
