package com.easygest.customerservice.roles.application.port.in;

import com.easygest.customerservice.roles.domain.model.RolesRecord;
import reactor.core.publisher.Mono;

public interface ManageRolesUseCase {

    Mono<RolesRecord> createRoles(RolesRecord record);

    Mono<RolesRecord> updateRoles(Long id, RolesRecord record);

    Mono<Void> deleteRoles(Long id);
}
