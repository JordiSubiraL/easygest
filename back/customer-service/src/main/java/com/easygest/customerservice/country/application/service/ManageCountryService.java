package com.easygest.customerservice.country.application.service;

import com.easygest.customerservice.country.application.port.in.ManageCountryUseCase;
import com.easygest.customerservice.country.application.port.out.CountryRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.country.domain.model.CountryRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageCountryService implements ManageCountryUseCase {

    private final CountryRepositoryPort repositoryPort;

    @Override
    public Mono<CountryRecord> createCountry(CountryRecord record) {
        return repositoryPort.createCountry(record);
    }

    @Override
    public Mono<CountryRecord> updateCountry(Long id, CountryRecord record) {
        return repositoryPort.getCountryById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Country not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateCountry(id, record));
    }

    @Override
    public Mono<Void> deleteCountry(Long id) {
        return repositoryPort.getCountryById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Country not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteCountry(id));
    }
}
