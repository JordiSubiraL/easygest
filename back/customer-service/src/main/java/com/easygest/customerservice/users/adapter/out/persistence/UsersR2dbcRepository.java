package com.easygest.customerservice.users.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UsersR2dbcRepository extends R2dbcRepository<UsersEntity, Long> {

    Mono<UsersEntity> findByUsername(String username);

    Mono<UsersEntity> findByEmail(String email);
}
