package com.easygest.customerservice.roles.application.service;

import com.easygest.customerservice.roles.application.port.in.ManageRolesUseCase;
import com.easygest.customerservice.roles.application.port.out.RolesRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.roles.domain.model.RolesRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageRolesService implements ManageRolesUseCase {

    private final RolesRepositoryPort repositoryPort;

    @Override
    public Mono<RolesRecord> createRoles(RolesRecord record) {
        return repositoryPort.createRoles(record);
    }

    @Override
    public Mono<RolesRecord> updateRoles(Long id, RolesRecord record) {
        return repositoryPort.getRolesById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Role not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateRoles(id, record));
    }

    @Override
    public Mono<Void> deleteRoles(Long id) {
        return repositoryPort.getRolesById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Role not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteRoles(id));
    }
}
