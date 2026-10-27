package com.easygest.customerservice.rolepermision.application.port.in;

import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetRolePermisionUseCase {

    Flux<RolePermisionRecord> getAllRolePermisions();

    Mono<RolePermisionRecord> getRolePermisionById(Long id);
}
