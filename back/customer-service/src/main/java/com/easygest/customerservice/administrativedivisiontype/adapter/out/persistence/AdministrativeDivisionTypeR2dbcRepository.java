package com.easygest.customerservice.administrativedivisiontype.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


public interface AdministrativeDivisionTypeR2dbcRepository extends R2dbcRepository<AdministrativeDivisionTypeEntity, Long> {

    Mono<AdministrativeDivisionTypeEntity> findByCode(String code);
}
