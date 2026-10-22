package com.easygest.customerservice.application.port.out.country;

import com.easygest.customerservice.domain.model.CountryRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryRepositoryPort {
    Flux<CountryRecord> getAllCountries();
    Mono<CountryRecord> getCountryByCode(String countryCode);
}
