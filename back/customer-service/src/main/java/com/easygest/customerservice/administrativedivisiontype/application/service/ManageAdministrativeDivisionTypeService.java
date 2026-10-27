package com.easygest.customerservice.administrativedivisiontype.application.service;

import com.easygest.customerservice.administrativedivisiontype.application.port.in.ManageAdministrativeDivisionTypeUseCase;
import com.easygest.customerservice.administrativedivisiontype.application.port.out.AdministrativeDivisionTypeRepositoryPort;
import com.easygest.customerservice.country.application.port.out.CountryRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageAdministrativeDivisionTypeService implements ManageAdministrativeDivisionTypeUseCase {

    private final AdministrativeDivisionTypeRepositoryPort repositoryPort;
    private final CountryRepositoryPort countryRepositoryPort;

    @Override
    public Mono<AdministrativeDivisionTypeRecord> createAdministrativeDivisionType(
            AdministrativeDivisionTypeRecord record) {
        return validateCountry(record)
                .then(repositoryPort.createAdministrativeDivisionType(record));
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> updateAdministrativeDivisionType(
            Long id, AdministrativeDivisionTypeRecord record) {
        return repositoryPort.getAdministrativeDivisionTypeById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(
                        "Administrative division type not found with id " + id)))
                .flatMap(existing -> validateCountry(record))
                .then(repositoryPort.updateAdministrativeDivisionType(id, record));
    }

    @Override
    public Mono<Void> deleteAdministrativeDivisionType(Long id) {
        return repositoryPort.getAdministrativeDivisionTypeById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(
                        "Administrative division type not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteAdministrativeDivisionType(id));
    }

    private Mono<Void> validateCountry(AdministrativeDivisionTypeRecord record) {
        return countryRepositoryPort.getCountryById(record.countryId())
                .switchIfEmpty(Mono.error(new NotFoundException("Country not found with id " + record.countryId())))
                .then();
    }
}
