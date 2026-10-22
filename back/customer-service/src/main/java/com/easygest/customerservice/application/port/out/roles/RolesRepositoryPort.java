package com.easygest.customerservice.application.port.out.roles;

import com.easygest.customerservice.domain.model.RolesRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolesRepositoryPort {
    Flux<RolesRecord> getAllRoles();
    Mono<RolesRecord> getRolesByCode(String code);
}
