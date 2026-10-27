package com.easygest.customerservice.memberrole.application.port.out;

import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberRoleRepositoryPort {

    Flux<MemberRoleRecord> getAllMemberRoles();

    Mono<MemberRoleRecord> getMemberRoleById(Long id);

    Mono<MemberRoleRecord> createMemberRole(MemberRoleRecord record);

    Mono<MemberRoleRecord> updateMemberRole(Long id, MemberRoleRecord record);

    Mono<Void> deleteMemberRole(Long id);
}
