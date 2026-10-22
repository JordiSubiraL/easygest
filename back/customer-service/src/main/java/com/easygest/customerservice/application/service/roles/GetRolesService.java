package com.easygest.customerservice.application.service.roles;

import com.easygest.customerservice.application.port.in.roles.GetRolesUseCase;
import com.easygest.customerservice.application.port.out.roles.RolesRepositoryPort;
import com.easygest.customerservice.domain.model.RolesRecord;
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
    public Mono<RolesRecord> getRolesByCode(String code) {
        return rolesRepositoryPort.getRolesByCode(code);
    }
}
