package com.easygest.customerservice.administrativedivision.application.port.in;

import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetAdministrativeDivisionUseCase {

    Flux<AdministrativeDivisionRecord> getAllAdministrativeDivision();

    Mono<AdministrativeDivisionRecord> getAdministrativeDivisionById(Long id);

    Mono<AdministrativeDivisionRecord> getAdministrativeDivisionByCode(String code);
}
