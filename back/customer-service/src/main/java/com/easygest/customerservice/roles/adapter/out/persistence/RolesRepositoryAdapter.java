package com.easygest.customerservice.roles.adapter.out.persistence;

import com.easygest.customerservice.roles.application.port.out.RolesRepositoryPort;
import com.easygest.customerservice.roles.domain.model.RolesRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RolesRepositoryAdapter implements RolesRepositoryPort {

    private final RolesR2dbcRepository repository;
    private final RolesMapper mapper;

    @Override
    public Flux<RolesRecord> getAllRoles() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<RolesRecord> getRolesById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<RolesRecord> getRolesByCode(String code) {
        return repository.findByCode(code).map(mapper::toDomain);
    }

    @Override
    public Mono<RolesRecord> createRoles(RolesRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<RolesRecord> updateRoles(Long id, RolesRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    RolesEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteRoles(Long id) {
        return repository.deleteById(id);
    }
}
