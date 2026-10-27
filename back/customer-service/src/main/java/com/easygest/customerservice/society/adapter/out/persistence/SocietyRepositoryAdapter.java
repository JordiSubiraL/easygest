package com.easygest.customerservice.society.adapter.out.persistence;

import com.easygest.customerservice.society.application.port.out.SocietyRepositoryPort;
import com.easygest.customerservice.society.domain.model.SocietyRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SocietyRepositoryAdapter implements SocietyRepositoryPort {

    private final SocietyR2dbcRepository repository;
    private final SocietyMapper mapper;

    @Override
    public Flux<SocietyRecord> getAllSocieties() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyRecord> getSocietyById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyRecord> getSocietyByPublicId(UUID publicId) {
        return repository.findByPublicId(publicId).map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyRecord> createSociety(SocietyRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyRecord> updateSociety(Long id, SocietyRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    SocietyEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteSociety(Long id) {
        return repository.deleteById(id);
    }
}
