package com.easygest.customerservice.permision.application.port.out;

import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PermisionRepositoryPort {

    Flux<PermisionRecord> getAllPermisions();

    Mono<PermisionRecord> getPermisionById(Long id);

    Mono<PermisionRecord> getPermisionByCode(String code);

    Mono<PermisionRecord> createPermision(PermisionRecord record);

    Mono<PermisionRecord> updatePermision(Long id, PermisionRecord record);

    Mono<Void> deletePermision(Long id);
}
