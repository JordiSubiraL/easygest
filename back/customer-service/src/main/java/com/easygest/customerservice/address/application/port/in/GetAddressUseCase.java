package com.easygest.customerservice.address.application.port.in;

import com.easygest.customerservice.address.domain.model.AddressRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetAddressUseCase {

    Flux<AddressRecord> getAllAddress();
    Mono<AddressRecord> getAddressById(Long id);
    Mono<AddressRecord> getAddressByAdmDivId(Long admDivId);
}
