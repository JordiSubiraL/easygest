package com.easygest.customerservice.society.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SocietyR2dbcRepository extends R2dbcRepository<SocietyEntity, Long> {

    Mono<SocietyEntity> findByPublicId(UUID publicId);
}
