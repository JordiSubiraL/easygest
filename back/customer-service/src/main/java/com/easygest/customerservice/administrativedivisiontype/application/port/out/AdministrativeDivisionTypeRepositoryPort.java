package com.easygest.customerservice.administrativedivisiontype.application.port.out;

import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdministrativeDivisionTypeRepositoryPort {

    Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes();

    Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeById(Long id);

    Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeByCode(String code);

    Mono<AdministrativeDivisionTypeRecord> createAdministrativeDivisionType(
            AdministrativeDivisionTypeRecord record);

    Mono<AdministrativeDivisionTypeRecord> updateAdministrativeDivisionType(
            Long id, AdministrativeDivisionTypeRecord record);

    Mono<Void> deleteAdministrativeDivisionType(Long id);
}
