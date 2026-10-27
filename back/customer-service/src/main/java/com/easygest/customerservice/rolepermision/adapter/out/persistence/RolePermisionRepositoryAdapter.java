package com.easygest.customerservice.rolepermision.adapter.out.persistence;

import com.easygest.customerservice.rolepermision.application.port.out.RolePermisionRepositoryPort;
import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RolePermisionRepositoryAdapter implements RolePermisionRepositoryPort {

    private final RolePermisionR2dbcRepository repository;
    private final RolePermisionMapper mapper;

    @Override
    public Flux<RolePermisionRecord> getAllRolePermisions() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<RolePermisionRecord> getRolePermisionById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<RolePermisionRecord> createRolePermision(RolePermisionRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<RolePermisionRecord> updateRolePermision(Long id, RolePermisionRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    RolePermisionEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteRolePermision(Long id) {
        return repository.deleteById(id);
    }
}
