package com.easygest.customerservice.country.application.port.in;

import com.easygest.customerservice.country.domain.model.CountryRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetCountryUseCase {
    Flux<CountryRecord> getAllCountries();
    Mono<CountryRecord> getCountryById(Long id);
    Mono<CountryRecord> getCountryByCode(String countryCode);
}
