package com.easygest.customerservice.roles.application.service;

import com.easygest.customerservice.roles.application.port.in.GetRolesUseCase;
import com.easygest.customerservice.roles.application.port.out.RolesRepositoryPort;
import com.easygest.customerservice.roles.domain.model.RolesRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetRolesService implements GetRolesUseCase {

    private final RolesRepositoryPort rolesRepositoryPort;

    @Override
    public Flux<RolesRecord> getAllRoles() {
        return rolesRepositoryPort.getAllRoles();
    }

    @Override
    public Mono<RolesRecord> getRolesById(Long id) {
        return rolesRepositoryPort.getRolesById(id);
    }

    @Override
    public Mono<RolesRecord> getRolesByCode(String code) {
        return rolesRepositoryPort.getRolesByCode(code);
    }
}
