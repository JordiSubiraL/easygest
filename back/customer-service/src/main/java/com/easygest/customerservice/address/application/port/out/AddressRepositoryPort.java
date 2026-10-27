package com.easygest.customerservice.address.application.port.out;

import com.easygest.customerservice.address.domain.model.AddressRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressRepositoryPort {

    Flux<AddressRecord> getAllAddress();

    Mono<AddressRecord> getAddressById(Long id);

    Mono<AddressRecord> getAddressByAdmDivId(Long admDivId);

    Mono<AddressRecord> createAddress(AddressRecord record);

    Mono<AddressRecord> updateAddress(Long id, AddressRecord record);

    Mono<Void> deleteAddress(Long id);
}
