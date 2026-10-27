package com.easygest.customerservice.businesstype.adapter.out.persistence;

import com.easygest.customerservice.businesstype.application.port.out.BusinessTypeRepositoryPort;
import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BusinessTypeRepositoryAdapter implements BusinessTypeRepositoryPort {

    private final BusinessTypeR2dbcRepository repository;
    private final BusinessTypeMapper mapper;

    @Override
    public Flux<BusinessTypeRecord> getAllBusinessTypes() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<BusinessTypeRecord> getBusinessTypeById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<BusinessTypeRecord> getBusinessTypeByCode(String code) {
        return repository.findByCode(code).map(mapper::toDomain);
    }

    @Override
    public Mono<BusinessTypeRecord> createBusinessType(BusinessTypeRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<BusinessTypeRecord> updateBusinessType(Long id, BusinessTypeRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    BusinessTypeEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteBusinessType(Long id) {
        return repository.deleteById(id);
    }
}
