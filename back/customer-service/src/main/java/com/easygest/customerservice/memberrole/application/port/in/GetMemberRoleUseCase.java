package com.easygest.customerservice.memberrole.application.port.in;

import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetMemberRoleUseCase {

    Flux<MemberRoleRecord> getAllMemberRoles();

    Mono<MemberRoleRecord> getMemberRoleById(Long id);
}
