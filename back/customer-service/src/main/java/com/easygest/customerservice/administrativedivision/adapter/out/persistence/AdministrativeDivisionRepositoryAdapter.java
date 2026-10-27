package com.easygest.customerservice.administrativedivision.adapter.out.persistence;

import com.easygest.customerservice.administrativedivision.application.port.out.AdministrativeDivisionRepositoryPort;
import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AdministrativeDivisionRepositoryAdapter implements AdministrativeDivisionRepositoryPort {

    private final AdministrativeDivisionR2dbcRepository repository;
    private final AdministrativeDivisionMapper mapper;

    @Override
    public Flux<AdministrativeDivisionRecord> getAllAdministrativeDivision() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<AdministrativeDivisionRecord> getAdministrativeDivisionById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<AdministrativeDivisionRecord> getAdministrativeDivisionByCode(String code) {
        return repository.getAdministrativeDivisionByCode(code).map(mapper::toDomain);
    }

    @Override
    public Mono<AdministrativeDivisionRecord> createAdministrativeDivision(AdministrativeDivisionRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<AdministrativeDivisionRecord> updateAdministrativeDivision(Long id, AdministrativeDivisionRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    AdministrativeDivisionEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteAdministrativeDivision(Long id) {
        return repository.deleteById(id);
    }
}
