package com.easygest.customerservice.businesstype.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface BusinessTypeR2dbcRepository extends R2dbcRepository<BusinessTypeEntity, Long>{

    Mono<BusinessTypeEntity> findByCode(String code);

}
