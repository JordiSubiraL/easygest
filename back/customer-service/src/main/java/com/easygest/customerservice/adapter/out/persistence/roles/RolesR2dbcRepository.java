package com.easygest.customerservice.adapter.out.persistence.roles;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RolesR2dbcRepository extends R2dbcRepository<RolesEntity,Long> {

    Mono<RolesEntity> findByCode(String code);
}
