package com.easygest.customerservice.rolepermision.application.port.out;

import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolePermisionRepositoryPort {

    Flux<RolePermisionRecord> getAllRolePermisions();

    Mono<RolePermisionRecord> getRolePermisionById(Long id);

    Mono<RolePermisionRecord> createRolePermision(RolePermisionRecord record);

    Mono<RolePermisionRecord> updateRolePermision(Long id, RolePermisionRecord record);

    Mono<Void> deleteRolePermision(Long id);
}
