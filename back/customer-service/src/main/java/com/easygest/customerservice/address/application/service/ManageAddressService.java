package com.easygest.customerservice.address.application.service;

import com.easygest.customerservice.address.application.port.in.ManageAddressUseCase;
import com.easygest.customerservice.address.application.port.out.AddressRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.address.domain.model.AddressRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageAddressService implements ManageAddressUseCase {

    private final AddressRepositoryPort repositoryPort;

    @Override
    public Mono<AddressRecord> createAddress(AddressRecord record) {
        return repositoryPort.createAddress(record);
    }

    @Override
    public Mono<AddressRecord> updateAddress(Long id, AddressRecord record) {
        return repositoryPort.getAddressById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Address not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateAddress(id, record));
    }

    @Override
    public Mono<Void> deleteAddress(Long id) {
        return repositoryPort.getAddressById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Address not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteAddress(id));
    }
}
