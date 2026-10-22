package com.easygest.customerservice.application.port.out.administrativedivisiontype;

import com.easygest.customerservice.domain.model.AdministrativeDivisionTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdministrativeDivisionTypeRepositoryPort {

    Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes();
    Mono<AdministrativeDivisionTypeRecord> getAdminitrativeDivisionTypeByCode(String code);

}
