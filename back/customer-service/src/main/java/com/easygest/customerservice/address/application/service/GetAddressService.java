package com.easygest.customerservice.address.application.service;

import com.easygest.customerservice.address.application.port.in.GetAddressUseCase;
import com.easygest.customerservice.address.application.port.out.AddressRepositoryPort;
import com.easygest.customerservice.address.domain.model.AddressRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetAddressService implements GetAddressUseCase {

    private final AddressRepositoryPort repositoryPort;

    @Override
    public Flux<AddressRecord> getAllAddress() {
        return repositoryPort.getAllAddress();
    }

    @Override
    public Mono<AddressRecord> getAddressById(Long id) {
        return repositoryPort.getAddressById(id);
    }

    @Override
    public Mono<AddressRecord> getAddressByAdmDivId(Long admDivId) {
        return repositoryPort.getAddressByAdmDivId(admDivId);
    }
}
