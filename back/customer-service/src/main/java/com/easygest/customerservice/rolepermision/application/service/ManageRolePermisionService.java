package com.easygest.customerservice.rolepermision.application.service;

import com.easygest.customerservice.rolepermision.application.port.in.ManageRolePermisionUseCase;
import com.easygest.customerservice.rolepermision.application.port.out.RolePermisionRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageRolePermisionService implements ManageRolePermisionUseCase {

    private final RolePermisionRepositoryPort repositoryPort;

    @Override
    public Mono<RolePermisionRecord> createRolePermision(RolePermisionRecord record) {
        return repositoryPort.createRolePermision(record);
    }

    @Override
    public Mono<RolePermisionRecord> updateRolePermision(Long id, RolePermisionRecord record) {
        return repositoryPort.getRolePermisionById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Role permission not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateRolePermision(id, record));
    }

    @Override
    public Mono<Void> deleteRolePermision(Long id) {
        return repositoryPort.getRolePermisionById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Role permission not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteRolePermision(id));
    }
}
