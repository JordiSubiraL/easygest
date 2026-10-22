package com.easygest.customerservice.application.port.in.roles;

import com.easygest.customerservice.domain.model.RolesRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetRolesUseCase {

    Flux<RolesRecord> getAllRoles();
    Mono<RolesRecord> getRolesByCode(String code);
}
