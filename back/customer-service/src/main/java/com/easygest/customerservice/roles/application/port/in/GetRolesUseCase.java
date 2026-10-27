package com.easygest.customerservice.roles.application.port.in;

import com.easygest.customerservice.roles.domain.model.RolesRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetRolesUseCase {

    Flux<RolesRecord> getAllRoles();

    Mono<RolesRecord> getRolesById(Long id);

    Mono<RolesRecord> getRolesByCode(String code);
}
