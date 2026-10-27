package com.easygest.customerservice.memberrole.application.service;

import com.easygest.customerservice.memberrole.application.port.in.GetMemberRoleUseCase;
import com.easygest.customerservice.memberrole.application.port.out.MemberRoleRepositoryPort;
import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetMemberRoleService implements GetMemberRoleUseCase {

    private final MemberRoleRepositoryPort repositoryPort;

    @Override
    public Flux<MemberRoleRecord> getAllMemberRoles() {
        return repositoryPort.getAllMemberRoles();
    }

    @Override
    public Mono<MemberRoleRecord> getMemberRoleById(Long id) {
        return repositoryPort.getMemberRoleById(id);
    }
}
