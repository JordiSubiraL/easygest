package com.easygest.customerservice.roles.application.port.out;

import com.easygest.customerservice.roles.domain.model.RolesRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolesRepositoryPort {
    Flux<RolesRecord> getAllRoles();

    Mono<RolesRecord> getRolesById(Long id);

    Mono<RolesRecord> getRolesByCode(String code);

    Mono<RolesRecord> createRoles(RolesRecord record);

    Mono<RolesRecord> updateRoles(Long id, RolesRecord record);

    Mono<Void> deleteRoles(Long id);
}
