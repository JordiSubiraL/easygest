package com.easygest.customerservice.country.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CountryR2dbcRepository extends R2dbcRepository<CountryEntity, Long> {
    Mono<CountryEntity> findByCode(String countryCode);
}
