package com.easygest.customerservice.adapter.out.persistence.country;

import com.easygest.customerservice.application.port.out.country.CountryRepositoryPort;
import com.easygest.customerservice.domain.model.CountryRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CountryRepositoryAdapter implements CountryRepositoryPort {

    private final CountryR2dbcRepository repository;
    private final CountryMapper mapper;

    @Override
    public Flux<CountryRecord> getAllCountries() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<CountryRecord> getCountryByCode(String countryCode) {
        return repository.findByCode(countryCode).map(mapper::toDomain);
    }
}
