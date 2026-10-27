package com.easygest.customerservice.country.adapter.out.persistence;

import com.easygest.customerservice.country.application.port.out.CountryRepositoryPort;
import com.easygest.customerservice.country.domain.model.CountryRecord;
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
    public Mono<CountryRecord> getCountryById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<CountryRecord> getCountryByCode(String countryCode) {
        return repository.findByCode(countryCode).map(mapper::toDomain);
    }

    @Override
    public Mono<CountryRecord> createCountry(CountryRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<CountryRecord> updateCountry(Long id, CountryRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    CountryEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteCountry(Long id) {
        return repository.deleteById(id);
    }
}
