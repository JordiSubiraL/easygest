package com.easygest.customerservice.rolepermision.application.service;

import com.easygest.customerservice.rolepermision.application.port.in.GetRolePermisionUseCase;
import com.easygest.customerservice.rolepermision.application.port.out.RolePermisionRepositoryPort;
import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetRolePermisionService implements GetRolePermisionUseCase {

    private final RolePermisionRepositoryPort repositoryPort;

    @Override
    public Flux<RolePermisionRecord> getAllRolePermisions() {
        return repositoryPort.getAllRolePermisions();
    }

    @Override
    public Mono<RolePermisionRecord> getRolePermisionById(Long id) {
        return repositoryPort.getRolePermisionById(id);
    }
}
