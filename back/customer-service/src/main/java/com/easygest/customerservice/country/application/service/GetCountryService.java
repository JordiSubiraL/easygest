package com.easygest.customerservice.country.application.service;

import com.easygest.customerservice.country.application.port.in.GetCountryUseCase;
import com.easygest.customerservice.country.application.port.out.CountryRepositoryPort;
import com.easygest.customerservice.country.domain.model.CountryRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetCountryService implements GetCountryUseCase {

    private final CountryRepositoryPort countryRespositoryPort;

    @Override
    public Flux<CountryRecord> getAllCountries() {
        return countryRespositoryPort.getAllCountries();
    }

    @Override
    public Mono<CountryRecord> getCountryById(Long id) {
        return countryRespositoryPort.getCountryById(id);
    }

    @Override
    public Mono<CountryRecord> getCountryByCode(String countryCode) {
        return countryRespositoryPort.getCountryByCode(countryCode);
    }
}
