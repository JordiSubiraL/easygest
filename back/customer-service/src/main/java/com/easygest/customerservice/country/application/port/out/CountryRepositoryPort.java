package com.easygest.customerservice.country.application.port.out;

import com.easygest.customerservice.country.domain.model.CountryRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryRepositoryPort {
    Flux<CountryRecord> getAllCountries();
    Mono<CountryRecord> getCountryById(Long id);
    Mono<CountryRecord> getCountryByCode(String countryCode);
    Mono<CountryRecord> createCountry(CountryRecord record);
    Mono<CountryRecord> updateCountry(Long id, CountryRecord record);
    Mono<Void> deleteCountry(Long id);
}
