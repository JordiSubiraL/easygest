package com.easygest.customerservice.status.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface StatusR2dbcRepository extends R2dbcRepository<StatusEntity, Long> {

    Mono<StatusEntity> findByCode(String code);
}
