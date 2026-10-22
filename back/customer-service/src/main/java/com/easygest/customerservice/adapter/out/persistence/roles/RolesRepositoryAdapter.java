package com.easygest.customerservice.adapter.out.persistence.roles;

import com.easygest.customerservice.application.port.out.roles.RolesRepositoryPort;
import com.easygest.customerservice.domain.model.RolesRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RolesRepositoryAdapter implements RolesRepositoryPort {

    private final RolesR2dbcRepository repository;
    private final RolesMapper mapper;


    @Override
    public Flux<RolesRecord> getAllRoles() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<RolesRecord> getRolesByCode(String code) {
        return repository.findByCode(code).map(mapper::toDomain);
    }
}
