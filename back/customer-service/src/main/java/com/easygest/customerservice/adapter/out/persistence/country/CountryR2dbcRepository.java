package com.easygest.customerservice.adapter.out.persistence.country;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CountryR2dbcRepository extends R2dbcRepository<CountryEntity, Long> {
    Mono<CountryEnti4ty> findByCode(String countryCode);
}
