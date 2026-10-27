package com.easygest.customerservice.memberrole.application.port.in;

import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import reactor.core.publisher.Mono;

public interface ManageMemberRoleUseCase {

    Mono<MemberRoleRecord> createMemberRole(MemberRoleRecord record);

    Mono<MemberRoleRecord> updateMemberRole(Long id, MemberRoleRecord record);

    Mono<Void> deleteMemberRole(Long id);
}
