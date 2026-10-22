package com.easygest.customerservice.application.port.in.administrativedivisiontype;

import com.easygest.customerservice.domain.model.AdministrativeDivisionTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetAdministrativeDivisionTypeUseCase {

    Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes();
    Mono<AdministrativeDivisionTypeRecord> getAdminitrativeDivisionTypeByCode(String code);

}
