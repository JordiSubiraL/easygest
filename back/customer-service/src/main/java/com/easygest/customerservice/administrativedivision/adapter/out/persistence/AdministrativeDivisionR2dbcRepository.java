package com.easygest.customerservice.administrativedivision.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface AdministrativeDivisionR2dbcRepository extends R2dbcRepository<AdministrativeDivisionEntity, Long> {

    Mono<AdministrativeDivisionEntity> getAdministrativeDivisionByCode(String code);
}
