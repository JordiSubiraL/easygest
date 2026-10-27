package com.easygest.customerservice.administrativedivisiontype.application.port.in;

import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetAdministrativeDivisionTypeUseCase {

    Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes();

    Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeById(Long id);

    Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeByCode(String code);
}
