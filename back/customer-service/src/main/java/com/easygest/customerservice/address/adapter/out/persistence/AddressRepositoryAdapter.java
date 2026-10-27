package com.easygest.customerservice.address.adapter.out.persistence;

import com.easygest.customerservice.address.application.port.out.AddressRepositoryPort;
import com.easygest.customerservice.address.domain.model.AddressRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddressRepositoryAdapter implements AddressRepositoryPort {

    private final AddressR2dbcRepository repository;
    private final AddressMapper mapper;

    @Override
    public Flux<AddressRecord> getAllAddress() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<AddressRecord> getAddressById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<AddressRecord> getAddressByAdmDivId(Long admDivId) {
        return repository.findByAdmDivId(admDivId).map(mapper::toDomain);
    }

    @Override
    public Mono<AddressRecord> createAddress(AddressRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<AddressRecord> updateAddress(Long id, AddressRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    AddressEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteAddress(Long id) {
        return repository.deleteById(id);
    }
}
