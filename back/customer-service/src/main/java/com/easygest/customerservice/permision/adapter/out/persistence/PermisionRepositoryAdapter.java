package com.easygest.customerservice.permision.adapter.out.persistence;

import com.easygest.customerservice.permision.application.port.out.PermisionRepositoryPort;
import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PermisionRepositoryAdapter implements PermisionRepositoryPort {

    private final PermisionR2dbcRepository repository;
    private final PermisionMapper mapper;

    @Override
    public Flux<PermisionRecord> getAllPermisions() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<PermisionRecord> getPermisionById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<PermisionRecord> getPermisionByCode(String code) {
        return repository.findByCode(code).map(mapper::toDomain);
    }

    @Override
    public Mono<PermisionRecord> createPermision(PermisionRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<PermisionRecord> updatePermision(Long id, PermisionRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    PermisionEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deletePermision(Long id) {
        return repository.deleteById(id);
    }
}
