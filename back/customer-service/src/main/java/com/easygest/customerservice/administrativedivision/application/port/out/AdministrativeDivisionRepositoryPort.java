package com.easygest.customerservice.administrativedivision.application.port.out;

import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdministrativeDivisionRepositoryPort {

    Flux<AdministrativeDivisionRecord> getAllAdministrativeDivision();

    Mono<AdministrativeDivisionRecord> getAdministrativeDivisionById(Long id);

    Mono<AdministrativeDivisionRecord> getAdministrativeDivisionByCode(String code);

    Mono<AdministrativeDivisionRecord> createAdministrativeDivision(AdministrativeDivisionRecord record);

    Mono<AdministrativeDivisionRecord> updateAdministrativeDivision(Long id, AdministrativeDivisionRecord record);

    Mono<Void> deleteAdministrativeDivision(Long id);
}
