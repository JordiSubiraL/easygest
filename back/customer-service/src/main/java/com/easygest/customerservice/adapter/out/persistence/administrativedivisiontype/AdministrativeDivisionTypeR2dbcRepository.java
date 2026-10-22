package com.easygest.customerservice.adapter.out.persistence.administrativedivisiontype;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


public interface AdministrativeDivisionTypeR2dbcRepository extends R2dbcRepository<AdministrativeDivisionTypeEntity, Long> {

    Mono<AdministrativeDivisionTypeEntity> findByCode(String code);
}
