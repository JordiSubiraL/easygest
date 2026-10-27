package com.easygest.customerservice.country.application.port.in;

import com.easygest.customerservice.country.domain.model.CountryRecord;
import reactor.core.publisher.Mono;

public interface ManageCountryUseCase {

    Mono<CountryRecord> createCountry(CountryRecord record);

    Mono<CountryRecord> updateCountry(Long id, CountryRecord record);

    Mono<Void> deleteCountry(Long id);
}
