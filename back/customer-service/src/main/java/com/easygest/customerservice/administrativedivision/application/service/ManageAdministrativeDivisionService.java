package com.easygest.customerservice.administrativedivision.application.service;

import com.easygest.customerservice.administrativedivision.application.port.in.ManageAdministrativeDivisionUseCase;
import com.easygest.customerservice.administrativedivision.application.port.out.AdministrativeDivisionRepositoryPort;
import com.easygest.customerservice.administrativedivisiontype.application.port.out.AdministrativeDivisionTypeRepositoryPort;
import com.easygest.customerservice.country.application.port.out.CountryRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageAdministrativeDivisionService implements ManageAdministrativeDivisionUseCase {

    private final AdministrativeDivisionRepositoryPort repositoryPort;
    private final AdministrativeDivisionTypeRepositoryPort divisionTypeRepositoryPort;
    private final CountryRepositoryPort countryRepositoryPort;

    @Override
    public Mono<AdministrativeDivisionRecord> createAdministrativeDivision(AdministrativeDivisionRecord record) {
        return validateReferences(record)
                .then(repositoryPort.createAdministrativeDivision(record));
    }

    @Override
    public Mono<AdministrativeDivisionRecord> updateAdministrativeDivision(Long id, AdministrativeDivisionRecord record) {
        return repositoryPort.getAdministrativeDivisionById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Administrative division not found with id " + id)))
                .flatMap(existing -> validateReferences(record))
                .then(repositoryPort.updateAdministrativeDivision(id, record));
    }

    @Override
    public Mono<Void> deleteAdministrativeDivision(Long id) {
        return repositoryPort.getAdministrativeDivisionById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Administrative division not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteAdministrativeDivision(id));
    }

    private Mono<Void> validateReferences(AdministrativeDivisionRecord record) {
        return countryRepositoryPort.getCountryById(record.countryId())
                .switchIfEmpty(Mono.error(new NotFoundException("Country not found with id " + record.countryId())))
                .then(divisionTypeRepositoryPort.getAdministrativeDivisionTypeById(record.admDivTypeId()))
                .switchIfEmpty(Mono.error(new NotFoundException(
                        "Administrative division type not found with id " + record.admDivTypeId())))
                .then();
    }
}
