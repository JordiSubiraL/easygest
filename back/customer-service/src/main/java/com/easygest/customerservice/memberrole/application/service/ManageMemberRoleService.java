package com.easygest.customerservice.memberrole.application.service;

import com.easygest.customerservice.memberrole.application.port.in.ManageMemberRoleUseCase;
import com.easygest.customerservice.memberrole.application.port.out.MemberRoleRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageMemberRoleService implements ManageMemberRoleUseCase {

    private final MemberRoleRepositoryPort repositoryPort;

    @Override
    public Mono<MemberRoleRecord> createMemberRole(MemberRoleRecord record) {
        return repositoryPort.createMemberRole(record);
    }

    @Override
    public Mono<MemberRoleRecord> updateMemberRole(Long id, MemberRoleRecord record) {
        return repositoryPort.getMemberRoleById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Member role not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateMemberRole(id, record));
    }

    @Override
    public Mono<Void> deleteMemberRole(Long id) {
        return repositoryPort.getMemberRoleById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Member role not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteMemberRole(id));
    }
}
