package com.easygest.customerservice.address.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface AddressR2dbcRepository extends R2dbcRepository<AddressEntity, Long> {

    Mono<AddressEntity> findByAdmDivId(Long admDivId);
}
