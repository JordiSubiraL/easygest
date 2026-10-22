package com.easygest.customerservice.application.service.country;

import com.easygest.customerservice.application.port.in.country.GetCountryUseCase;
import com.easygest.customerservice.application.port.out.country.CountryRepositoryPort;
import com.easygest.customerservice.domain.model.CountryRecord;
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
    public Mono<CountryRecord> getCountryByCode(String countryCode) {
        return countryRespositoryPort.getCountryByCode(countryCode);
    }
}
