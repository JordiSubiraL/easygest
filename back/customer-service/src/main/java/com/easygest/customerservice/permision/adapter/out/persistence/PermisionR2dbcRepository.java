package com.easygest.customerservice.permision.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface PermisionR2dbcRepository extends R2dbcRepository<PermisionEntity, Long> {

    Mono<PermisionEntity> findByCode(String code);
}
