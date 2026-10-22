package com.easygest.customerservice.application.port.in.country;

import com.easygest.customerservice.domain.model.CountryRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetCountryUseCase {
    Flux<CountryRecord> getAllCountries();
    Mono<CountryRecord> getCountryByCode(String countryCode);
}
