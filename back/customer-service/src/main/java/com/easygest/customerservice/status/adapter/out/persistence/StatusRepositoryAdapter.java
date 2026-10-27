package com.easygest.customerservice.status.adapter.out.persistence;

import com.easygest.customerservice.status.application.port.out.StatusRepositoryPort;
import com.easygest.customerservice.status.domain.model.StatusRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StatusRepositoryAdapter implements StatusRepositoryPort {

    private final StatusR2dbcRepository repository;
    private final StatusMapper mapper;

    @Override
    public Flux<StatusRecord> getAllStatuses() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<StatusRecord> getStatusById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<StatusRecord> getStatusByCode(String code) {
        return repository.findByCode(code).map(mapper::toDomain);
    }

    @Override
    public Mono<StatusRecord> createStatus(StatusRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<StatusRecord> updateStatus(Long id, StatusRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    StatusEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteStatus(Long id) {
        return repository.deleteById(id);
    }
}
