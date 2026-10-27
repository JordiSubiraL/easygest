package com.easygest.customerservice.roles.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RolesR2dbcRepository extends R2dbcRepository<RolesEntity,Long> {

    Mono<RolesEntity> findByCode(String code);
}
