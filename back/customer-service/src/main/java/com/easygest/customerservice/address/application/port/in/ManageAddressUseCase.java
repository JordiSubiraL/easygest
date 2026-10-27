package com.easygest.customerservice.address.application.port.in;

import com.easygest.customerservice.address.domain.model.AddressRecord;
import reactor.core.publisher.Mono;

public interface ManageAddressUseCase {

    Mono<AddressRecord> createAddress(AddressRecord record);

    Mono<AddressRecord> updateAddress(Long id, AddressRecord record);

    Mono<Void> deleteAddress(Long id);
}
